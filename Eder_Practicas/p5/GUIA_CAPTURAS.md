# 📸 GUÍA RÁPIDA - Capturas de Pantalla para Postman

## ⚡ Pasos Rápidos

### 1️⃣ Preparación (2 minutos)

**A. Iniciar el servidor**
```powershell
cd c:\Users\Nefta\Eder_Practicas\p5
php artisan serve
```
✅ Verificar que diga: "Server running on [http://127.0.0.1:8000]"

**B. Abrir Postman**
1. Abrir Postman en tu computadora
2. Click en "Import" (botón naranja, esquina superior izquierda)
3. Click en "Upload Files"
4. Buscar y seleccionar: `c:\Users\Nefta\Eder_Practicas\p5\postman_collection.json`
5. Click en "Import"

✅ Deberías ver: "Medical API - CRUD Complete" en tu panel izquierdo

---

### 2️⃣ Captura 1: GET (Index) - Lista completa

**Endpoint**: `GET /api/specialties`

**Pasos**:
1. En Postman, expandir "Medical API - CRUD Complete"
2. Expandir carpeta "Specialties"
3. Click en "Get All Specialties"
4. Click en el botón azul "Send"
5. Esperar la respuesta (debe aparecer un array JSON)
6. **Tomar captura de pantalla completa**

**Qué debe verse en la captura**:
- ✅ URL: `http://localhost:8000/api/specialties`
- ✅ Método: GET
- ✅ Status: 200 OK
- ✅ Response body: Array con objetos JSON

**Ejemplo de respuesta esperada**:
```json
[
    {
        "id": 1,
        "name": "Cardiology Updated",
        "description": "Heart and cardiovascular...",
        "created_at": "2025-11-30...",
        "updated_at": "2025-11-30..."
    },
    ...
]
```

---

### 3️⃣ Captura 2: POST (Store) - Crear nuevo recurso

**Endpoint**: `POST /api/specialties`

**Pasos**:
1. En la carpeta "Specialties", click en "Create Specialty"
2. Verificar que el Body ya tiene el JSON:
   ```json
   {
       "name": "Cardiology",
       "description": "Heart and cardiovascular system specialist"
   }
   ```
3. Click en el botón azul "Send"
4. Esperar la respuesta (debe aparecer el objeto creado)
5. **Tomar captura de pantalla completa**

**Qué debe verse en la captura**:
- ✅ URL: `http://localhost:8000/api/specialties`
- ✅ Método: POST
- ✅ Status: 201 Created
- ✅ Body (tab): Mostrando el JSON enviado
- ✅ Response: Objeto creado con ID

**Ejemplo de respuesta esperada**:
```json
{
    "name": "Cardiology",
    "description": "Heart and cardiovascular system specialist",
    "updated_at": "2025-11-30T22:12:03.000000Z",
    "created_at": "2025-11-30T22:12:03.000000Z",
    "id": 5
}
```

---

### 4️⃣ Captura 3: GET (Show) - Un recurso específico

**Endpoint**: `GET /api/specialties/1`

**Pasos**:
1. En la carpeta "Specialties", click en "Get Single Specialty"
2. Verificar la URL: debe terminar en `/api/specialties/1`
3. Click en el botón azul "Send"
4. Esperar la respuesta (debe aparecer UN solo objeto)
5. **Tomar captura de pantalla completa**

**Qué debe verse en la captura**:
- ✅ URL: `http://localhost:8000/api/specialties/1`
- ✅ Método: GET
- ✅ Status: 200 OK
- ✅ Response: UN objeto JSON con el ID solicitado

**Ejemplo de respuesta esperada**:
```json
{
    "id": 1,
    "name": "Cardiology Updated",
    "description": "Heart and cardiovascular system specialist - Updated",
    "created_at": "2025-11-30T22:11:35.000000Z",
    "updated_at": "2025-11-30T22:12:37.000000Z"
}
```

---

## 💡 Consejos para Buenas Capturas

### ✅ Asegúrate de que se vea:
- El método HTTP (GET, POST, etc.) y la URL completa
- El código de status (200 OK, 201 Created)
- El request body completo (para POST/PUT)
- La respuesta JSON completa y legible
- Los tabs de Postman (Params, Headers, Body, etc.)

### ❌ Evita:
- Capturas cortadas o parciales
- Respuestas de error (código 404, 500, etc.)
- Ventanas superpuestas
- Texto ilegible

### 🎨 Mejora la captura:
1. Maximizar la ventana de Postman
2. Hacer zoom si es necesario (Ctrl + / Ctrl -)
3. Cerrar ventanas innecesarias
4. Usar el modo "Pretty" para JSON (botón en la respuesta)

---

## 🔥 Capturas Adicionales (Opcionales pero Recomendadas)

### Captura Extra 1: PUT (Update)
**Endpoint**: `PUT /api/specialties/1`

**Pasos**:
1. Click en "Update Specialty"
2. Verificar el Body:
   ```json
   {
       "name": "Cardiology Updated",
       "description": "Heart and cardiovascular system specialist - Updated"
   }
   ```
3. Send → Captura

**Muestra**: Actualización exitosa con código 200

---

### Captura Extra 2: DELETE
**Endpoint**: `DELETE /api/specialties/1`

**Pasos**:
1. Click en "Delete Specialty"
2. Verificar URL termina en `/1`
3. Send → Captura

**Muestra**: Eliminación exitosa con mensaje de confirmación

---

### Captura Extra 3: GET Appointments (Con Relaciones)
**Endpoint**: `GET /api/appointments`

**Pasos**:
1. Expandir carpeta "Appointments"
2. Click en "Get All Appointments"
3. Send → Captura

**Por qué es interesante**: 
Muestra las relaciones complejas (Patient + Doctor + Specialty en una sola respuesta)

---

## 🐛 Solución de Problemas

### ❌ Error: "Could not get any response"
**Solución**: 
```powershell
# Verificar que el servidor está corriendo
php artisan serve
```

### ❌ Error 404 - Not Found
**Solución**: Verificar que la URL sea exactamente:
- `http://localhost:8000/api/specialties`
- (No olvidar el `/api/`)

### ❌ Error 500 - Server Error
**Solución**: Verificar que las migraciones estén ejecutadas:
```powershell
php artisan migrate
```

### ❌ La colección no aparece en Postman
**Solución**:
1. File → Import
2. Upload Files
3. Seleccionar `postman_collection.json`
4. Import

---

## 📋 Checklist de Entrega

Antes de entregar, verifica que tengas:

- [ ] ✅ Servidor Laravel corriendo (php artisan serve)
- [ ] ✅ Colección importada en Postman
- [ ] ✅ Captura 1: GET /api/specialties (Index)
- [ ] ✅ Captura 2: POST /api/specialties (Store)
- [ ] ✅ Captura 3: GET /api/specialties/1 (Show)
- [ ] ✅ Archivo postman_collection.json
- [ ] ✅ Las 3 capturas muestran código 200/201
- [ ] ✅ Las capturas son legibles y completas

---

## 📎 Formato de Entrega

### Nombres de archivos sugeridos:
```
1_GET_Index_Specialties.png
2_POST_Store_Specialty.png
3_GET_Show_Specialty.png
postman_collection.json
```

### Estructura de carpeta sugerida:
```
Entrega_P5/
├── capturas/
│   ├── 1_GET_Index_Specialties.png
│   ├── 2_POST_Store_Specialty.png
│   └── 3_GET_Show_Specialty.png
└── postman_collection.json
```

---

## ⏱️ Tiempo Estimado

- Importar colección: 1 minuto
- Tomar 3 capturas: 3 minutos
- Organizar archivos: 1 minuto

**Total**: ~5 minutos

---

## 🎯 Resultado Final Esperado

Al terminar, deberías tener:

✅ 3 capturas de pantalla que muestren:
   - Lista completa (GET index)
   - Creación exitosa (POST store)
   - Detalle individual (GET show)

✅ Archivo `postman_collection.json`

✅ Todo funcionando correctamente

---

## 📞 ¿Necesitas Ayuda?

### Referencia rápida:
- Ver ejemplos de respuestas: `API_TEST_REPORT.md`
- Ver documentación completa: `README_API.md`
- Ver instrucciones de entrega: `ENTREGA.md`

### Comandos útiles:
```powershell
# Iniciar servidor
php artisan serve

# Ver rutas disponibles
php artisan route:list --path=api

# Probar API con script
.\test_api.ps1
```

---

**¡Listo! Con esto deberías poder tomar todas las capturas necesarias en menos de 5 minutos.**

**¡Buena suerte con tu entrega! 🚀**
