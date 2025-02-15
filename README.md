# 📜 Cahier des Charges - ClaimFlow API

## 1️⃣ Contexte et Objectif  

ClaimFlow API est une solution permettant aux compagnies d’assurance de **gérer les sinistres**, depuis la déclaration jusqu'à l'indemnisation.  
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

### ✅ US 4 : Indemnisation et Paiement  
- L’API calcule l’indemnisation en fonction des garanties du contrat et des franchises.  
- Le paiement ne peut pas excéder le plafond contractuel.  

### ✅ US 5 : Gestion des Litiges  
- Un client peut contester une indemnisation via un **recours**.  
- L’API impose un **délai maximal de réponse** pour le traitement du litige.  

---

## 3️⃣ Contraintes Techniques  

| Technologie      | Détails |
|-----------------|---------|
| **Langage**     | Java (Spring Boot) ou Python (FastAPI) |
| **Base de données** | PostgreSQL ou MySQL |
| **Format des échanges** | JSON |
| **Gestion des fichiers** | Stockage des documents sur AWS S3 ou Google Cloud Storage |
| **Gestion des délais** | Utilisation de `java.time` (Spring) ou `datetime` (Python) |

---

## 4️⃣ Endpoints de l’API  

### **📌 Gestion des Sinistres**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **POST** | `/sinistres` | Déclarer un sinistre |
| **GET** | `/sinistres?client_id={id}` | Récupérer tous les sinistres d’un client |
| **GET** | `/sinistres/{sinistre_id}` | Récupérer les détails d’un sinistre |
| **PATCH** | `/sinistres/{sinistre_id}` | Modifier un sinistre (ajout d’infos) |

### **📌 Gestion des Expertises**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **POST** | `/sinistres/{sinistre_id}/expert` | Assigner un expert à un sinistre |
| **GET** | `/experts/{expert_id}/sinistres` | Voir les dossiers d’un expert |

### **📌 Indemnisation et Paiements**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **GET** | `/sinistres/{sinistre_id}/indemnisation` | Calculer le montant estimé |
| **POST** | `/sinistres/{sinistre_id}/payer` | Valider le paiement de l’indemnisation |

### **📌 Gestion des Litiges**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **POST** | `/sinistres/{sinistre_id}/recours` | Soumettre un recours |
| **GET** | `/sinistres/{sinistre_id}/recours` | Vérifier le statut du recours |

### **📌 Statistiques et Suivi**  

| Méthode | Endpoint | Description |
|---------|---------|-------------|
| **GET** | `/statistiques` | Voir les statistiques des sinistres |

---

## 5️⃣ Livrables  

- **📌 Code source** : Dépôt GitHub public avec un README détaillé.  
- **📄 Documentation API** : Générée via Swagger/Postman.  
- **📂 Base de données** : Script SQL pour créer les tables.  
- **📊 Exemples de cas métiers** : Scénarios de test des règles métiers.  

---

🚀 **ClaimFlow API est conçue pour gérer les sinistres avec des règles strictes et un suivi transparent !**  
🎯 **Besoin d'ajouter quelque chose ?** 😊
