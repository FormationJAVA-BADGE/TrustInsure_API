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