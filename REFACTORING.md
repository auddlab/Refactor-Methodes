# Journal de refactoring

| Classe/méthode | Problème observé | Refactoring appliqué | Justification |
|---|---|---|---|
|Customer / CustomerState | Méthode avec plus de 3 paramètres. | Regrouper 3 paramètres de Customer sur 6 dans un autre objet (CustomerState) | Pour réduire le nombre de paramètre afin d'alléger le code et de façon logique selon leur fonctionnement |
