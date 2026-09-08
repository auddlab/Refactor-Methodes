# Journal de refactoring

| Classe/méthode | Problème observé | Refactoring appliqué | Justification |
|---|---|---|---|
|Customer / CustomerState | Méthode avec plus de 3 paramètres | Regrouper 3 paramètres de Customer sur 6 dans un autre objet (CustomerState) | Pour réduire le nombre de paramètres afin d'alléger le code et de façon logique selon leur fonctionnement |
|Shipment / ShipementInfo | Méthode avec plus de 4 paramètres | Regrouper 4 paramètres de Shipment sur 7 dans un autre objet (ShipmentInfo) | Réduire le nombre de paramètres afin d'alléger le code et de le placer de façon logique selon leur fonctionnement  
