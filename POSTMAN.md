# Creer un sinistre

POST /sinistres/

```
{
  "typeSinistre": "Accident",
  "dateSinistre": "2025-02-15T10:30:00",
  "description": "Collision avec un autre véhicule",
  "clientId": 1,
  "documentsUrls": [
    "https://example.com/image1.jpg",
    "https://example.com/image2.jpg"
  ]
}
```

# Suivre un sinistre

GET /sinistres/{sinistreId}

