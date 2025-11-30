# 📸 Capturas de Pantalla - API Medical Management System

## 📋 Contenido de la Carpeta

Esta carpeta contiene las evidencias fotográficas del funcionamiento de la API CRUD.

---

## 🖼️ Capturas Incluidas

### 1. GetAllSpecialities.png
**Endpoint**: `GET /api/specialties`  
**Método**: GET (Index)  
**Descripción**: Lista todas las especialidades médicas  
**Código respuesta**: 200 OK  
**Demuestra**: Método `index()` funcionando correctamente

---

### 2. CreateSpeciality.png
**Endpoint**: `POST /api/specialties`  
**Método**: POST (Store)  
**Descripción**: Crea una nueva especialidad médica  
**Código respuesta**: 201 Created  
**Demuestra**: Método `store()` funcionando correctamente

**Request Body**:
```json
{
    "name": "Cardiology",
    "description": "Heart and cardiovascular system specialist"
}
```

---

### 3. Single.png
**Endpoint**: `GET /api/specialties/1`  
**Método**: GET (Show)  
**Descripción**: Obtiene una especialidad específica por ID  
**Código respuesta**: 200 OK  
**Demuestra**: Método `show()` funcionando correctamente

---

### 4. JSON.png
**Descripción**: Vista del formato JSON en Postman  
**Demuestra**: Respuestas JSON bien formateadas y legibles  
**Modo**: Pretty (formato legible)

---

## ✅ Verificación de Calidad

Todas las capturas cumplen con:
- ✅ URL completa visible
- ✅ Método HTTP visible (GET, POST)
- ✅ Código de respuesta visible (200, 201)
- ✅ Request body visible (cuando aplica)
- ✅ Response body completo y legible
- ✅ Sin errores
- ✅ Formato profesional

---

## 📊 Resumen de Capturas

| Captura | Método | Endpoint | Status | Propósito |
|---------|--------|----------|--------|-----------|
| GetAllSpecialities.png | GET | /api/specialties | 200 | Listar todos |
| CreateSpeciality.png | POST | /api/specialties | 201 | Crear nuevo |
| Single.png | GET | /api/specialties/1 | 200 | Ver uno |
| JSON.png | - | - | - | Formato JSON |

---

## 📦 Uso en la Entrega

Estas capturas son parte integral de la entrega del proyecto y demuestran:
1. La API está funcionando correctamente
2. Los endpoints responden con los códigos HTTP apropiados
3. Las respuestas están en formato JSON válido
4. Los métodos CRUD están implementados

---

## 🔗 Referencias

Para más información, consultar:
- `../DOCUMENTO_ENTREGA.md` - Documento completo de entrega
- `../API_TEST_REPORT.md` - Reporte detallado de pruebas
- `../postman_collection.json` - Colección completa de Postman

---

**Fecha**: 30 de Noviembre de 2025  
**Proyecto**: API Medical Management System  
**Estado**: ✅ Capturas completas y verificadas
