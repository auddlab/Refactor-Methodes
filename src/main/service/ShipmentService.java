package main.service;

import main.domain.Cargo;
import main.domain.Shipment;
import main.domain.ShipmentInfo;

public class ShipmentService {
    private final PricingService pricingService;
    private final PermissionService permissionService;
    private final ManifestRepository repository;
    private final NotificationService notificationService;

    public ShipmentService(PricingService pricingService, PermissionService permissionService,
                           ManifestRepository repository, NotificationService notificationService) {
        this.pricingService = pricingService;
        this.permissionService = permissionService;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public String validateCalculatePrintSaveAndNotify(Shipment shipment, ShipmentInfo shipmentInfo) {
        if (shipment.getCustomerState().isActive()) {
            if (!shipment.getCustomerState().isSuspended()) {
                if (!shipment.getCargo().isEmpty()) {
                    double totalWeight = 0;
                    double totalValue = 0;
                    boolean hazardous = false;
                    for (Cargo item : shipment.getCargo()) {
                        totalWeight += item.getWeight();
                        totalValue += item.getDeclaredValue();
                        if (item.isHazardous()) hazardous = true;
                    }
                    if (totalWeight > shipmentInfo.getShip().getCapacity()) return "ERROR_CAPACITY";
                    if (hazardous && !permissionService.canCarryHazardous(shipmentInfo.getShip())) return "ERROR_PERMISSION";

                    double total = pricingService.calculatePrice(
                            totalWeight, totalValue, hazardous,
                            shipmentInfo.getOrigin().getName(), shipmentInfo.getOrigin().getSector(), shipmentInfo.getOrigin().getSecurityLevel(),
                            shipmentInfo.getDestination().getName(), shipmentInfo.getDestination().getSector(), shipmentInfo.getDestination().getSecurityLevel(),
                            shipment.getCustomer().getLoyaltyYears(), shipment.getCustomerState().isActive(), shipment.getCustomerState().isSuspended(),
                            shipmentInfo.getDepartureDate());
                    total += pricingService.calculateInsurance(totalValue, hazardous, shipment.getCustomer());

                    shipment.setTotal(total);
                    shipment.setStatus("READY");
                    String output;
                    if (total > 2000) {
                        output = "PRIORITY | " + shipment.getReference() + " | " + String.format("%.2f", total);
                        repository.save(shipment);
                        output += " | " + notificationService.confirmationFor(shipment);
                    } else {
                        output = "REGULAR | " + shipment.getReference() + " | " + String.format("%.2f", total);
                        repository.save(shipment);
                        output += " | " + notificationService.confirmationFor(shipment);
                    }
                    return output;
                } else {
                    return "ERROR_EMPTY";
                }
            } else {
                return "ERROR_CUSTOMER";
            }
        } else {
            return "ERROR_CUSTOMER";
        }
    }
}
