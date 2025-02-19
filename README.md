# Cahier des charges - TrutInsure

## 1️⃣ Contexte et Objectif  

TrustInsure API est une solution permettant aux compagnies d’assurance de **gérer les sinistres**, depuis la déclaration jusqu'à l'indemnisation.  
Cette API facilitera le suivi des sinistres et optimisera les processus métiers liés aux expertises, indemnisations et litiges.  

## 2️⃣ Fonctionnalités Demandées (User Stories)  

### ✅ US 1 : Déclaration d’un Sinistre  
- Un client peut déclarer un sinistre en précisant les détails (type, date, description, photos).  
- L’API vérifie l’éligibilité du contrat avant d’enregistrer le sinistre.  

### ✅ US 2 : Suivi du Traitement du Sinistre  
- Un client peut consulter l’état d’avancement de son sinistre.  
- Un gestionnaire peut modifier l’état du dossier à chaque étape.  

### ✅ US 3 : Gestion des Expertises  
- Un expert peut être assigné à un sinistre nécessitant une validation.  
- L’API calcule la **date limite d’expertise** en fonction du type de sinistre.  


### ✅ US 4 : Gestion des Litiges  
- Un client peut contester une indemnisation via un **recours**.  
- L’API impose un **délai maximal de réponse** pour le traitement du litige.  

---



## 4️⃣ Endpoints de l’API  

### **📌 Gestion des Sinistres**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **POST** | `/api/v1/sinistres` | Déclarer un sinistre |
| **GET** | `/api/v1/sinistres/{id}` | Récupérer tous les sinistres d’un client |
| **GET** | `/api/v1/sinistres/{sinistre_id}` | Récupérer les détails d’un sinistre |
| **PUT** | `/api/v1/sinistres/{sinistre_id}` | Modifier un sinistre (ajout d’infos) |

### **📌 Gestion des Expertises**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **POST** | `/api/v1/sinistres/{sinistre_id}/expert` | Assigner un expert à un sinistre |
| **GET** | `/api/v1/experts/{expert_id}/sinistres` | Voir les dossiers d’un expert |

### **📌 Indemnisation et Paiements**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **GET** | `/api/v1/sinistres/{sinistre_id}/indemnisation` | Calculer le montant estimé |
| **POST** | `/api/v1/sinistres/{sinistre_id}/payer` | Valider le paiement de l’indemnisation |

### **📌 Gestion des Litiges**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **POST** | `/api/v1/sinistres/{sinistre_id}/recours` | Soumettre un recours |
| **GET** | `/api/v1/sinistres/{sinistre_id}/recours` | Vérifier le statut du recours |

### **📌 Statistiques et Suivi**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **GET** | `/api/v1/statistiques` | Voir les statistiques des sinistres |

---

