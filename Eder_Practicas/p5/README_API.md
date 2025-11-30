# Medical Management System - API CRUD

Sistema completo de gestión médica con API RESTful para gestionar especialidades, doctores, pacientes y citas.

## 📋 Requisitos

- PHP 8.2 o superior
- Composer
- SQLite (incluido por defecto)

## 🚀 Instalación

1. Navegar al directorio del proyecto:
```bash
cd c:\Users\Nefta\Eder_Practicas\p5
```

2. Instalar dependencias (ya instaladas):
```bash
composer install
```

3. Ejecutar migraciones (ya ejecutadas):
```bash
php artisan migrate
```

## 🎯 Iniciar el Servidor

```bash
php artisan serve
```

El servidor estará disponible en: `http://localhost:8000`

## 📚 Recursos de la API

### 1. Specialties (Especialidades)
- `GET /api/specialties` - Obtener todas las especialidades
- `GET /api/specialties/{id}` - Obtener una especialidad
- `POST /api/specialties` - Crear especialidad
- `PUT /api/specialties/{id}` - Actualizar especialidad
- `DELETE /api/specialties/{id}` - Eliminar especialidad

**Campos**:
- `name` (requerido): Nombre de la especialidad
- `description` (opcional): Descripción

### 2. Doctors (Doctores)
- `GET /api/doctors` - Obtener todos los doctores
- `GET /api/doctors/{id}` - Obtener un doctor
- `POST /api/doctors` - Crear doctor
- `PUT /api/doctors/{id}` - Actualizar doctor
- `DELETE /api/doctors/{id}` - Eliminar doctor

**Campos**:
- `name` (requerido): Nombre del doctor
- `email` (requerido): Email único
- `phone` (opcional): Teléfono
- `specialty_id` (requerido): ID de la especialidad

### 3. Patients (Pacientes)
- `GET /api/patients` - Obtener todos los pacientes
- `GET /api/patients/{id}` - Obtener un paciente
- `POST /api/patients` - Crear paciente
- `PUT /api/patients/{id}` - Actualizar paciente
- `DELETE /api/patients/{id}` - Eliminar paciente

**Campos**:
- `name` (requerido): Nombre del paciente
- `email` (requerido): Email único
- `phone` (opcional): Teléfono
- `birth_date` (opcional): Fecha de nacimiento (formato: YYYY-MM-DD)
- `address` (opcional): Dirección

### 4. Appointments (Citas)
- `GET /api/appointments` - Obtener todas las citas
- `GET /api/appointments/{id}` - Obtener una cita
- `POST /api/appointments` - Crear cita
- `PUT /api/appointments/{id}` - Actualizar cita
- `DELETE /api/appointments/{id}` - Eliminar cita

**Campos**:
- `patient_id` (requerido): ID del paciente
- `doctor_id` (requerido): ID del doctor
- `appointment_date` (requerido): Fecha y hora de la cita
- `status` (opcional): Estado (pending, confirmed, completed, cancelled)
- `notes` (opcional): Notas adicionales

## 📮 Colección de Postman

La colección completa está disponible en: `postman_collection.json`

Para importar en Postman:
1. Abrir Postman
2. Click en "Import"
3. Seleccionar el archivo `postman_collection.json`
4. ¡Listo! Todas las peticiones están configuradas

## 🧪 Ejemplos de Uso

### Crear una Especialidad
```bash
POST http://localhost:8000/api/specialties
Content-Type: application/json

{
    "name": "Cardiology",
    "description": "Heart and cardiovascular system specialist"
}
```

### Crear un Doctor
```bash
POST http://localhost:8000/api/doctors
Content-Type: application/json

{
    "name": "Dr. John Smith",
    "email": "john.smith@hospital.com",
    "phone": "+1234567890",
    "specialty_id": 1
}
```

### Crear un Paciente
```bash
POST http://localhost:8000/api/patients
Content-Type: application/json

{
    "name": "Jane Doe",
    "email": "jane.doe@email.com",
    "phone": "+0987654321",
    "birth_date": "1990-05-15",
    "address": "123 Main Street, City, Country"
}
```

### Crear una Cita
```bash
POST http://localhost:8000/api/appointments
Content-Type: application/json

{
    "patient_id": 1,
    "doctor_id": 1,
    "appointment_date": "2025-12-15 10:00:00",
    "status": "pending",
    "notes": "Regular checkup"
}
```

## 📂 Estructura del Proyecto

```
p5/
├── app/
│   ├── Http/
│   │   └── Controllers/
│   │       └── Api/
│   │           ├── SpecialtyController.php
│   │           ├── DoctorController.php
│   │           ├── PatientController.php
│   │           └── AppointmentController.php
│   └── Models/
│       ├── Specialty.php
│       ├── Doctor.php
│       ├── Patient.php
│       └── Appointment.php
├── database/
│   ├── migrations/
│   │   ├── 2025_11_30_215445_create_specialties_table.php
│   │   ├── 2025_11_30_215449_create_doctors_table.php
│   │   ├── 2025_11_30_215453_create_patients_table.php
│   │   └── 2025_11_30_215457_create_appointments_table.php
│   └── database.sqlite
├── routes/
│   └── api.php
├── postman_collection.json
└── API_TEST_REPORT.md
```

## ✅ Funcionalidades Implementadas

- ✅ CRUD completo para 4 recursos
- ✅ Validación de datos
- ✅ Relaciones entre modelos (Foreign Keys)
- ✅ Eager Loading para optimización
- ✅ Respuestas JSON estructuradas
- ✅ Códigos de estado HTTP apropiados
- ✅ Arquitectura RESTful

## 📊 Base de Datos

### Tablas

1. **specialties**
   - id (PK)
   - name
   - description
   - timestamps

2. **doctors**
   - id (PK)
   - name
   - email (unique)
   - phone
   - specialty_id (FK)
   - timestamps

3. **patients**
   - id (PK)
   - name
   - email (unique)
   - phone
   - birth_date
   - address
   - timestamps

4. **appointments**
   - id (PK)
   - patient_id (FK)
   - doctor_id (FK)
   - appointment_date
   - status
   - notes
   - timestamps

### Relaciones

- `Specialty` hasMany `Doctor`
- `Doctor` belongsTo `Specialty`
- `Doctor` hasMany `Appointment`
- `Patient` hasMany `Appointment`
- `Appointment` belongsTo `Doctor`
- `Appointment` belongsTo `Patient`

## 🧪 Pruebas Realizadas

Ver el archivo `API_TEST_REPORT.md` para el reporte completo de pruebas.

**Resumen**:
- Total de pruebas: 10
- Exitosas: ✅ 10
- Fallidas: ❌ 0
- Tasa de éxito: 100%

## 📝 Notas

- La API usa SQLite como base de datos por simplicidad
- Todos los endpoints están protegidos con validación de datos
- Las relaciones se cargan automáticamente donde es relevante
- Los timestamps se manejan automáticamente por Laravel

## 👨‍💻 Desarrollo

Creado con Laravel 12.40.2 y PHP 8.2.29

## 📄 Licencia

Este proyecto es de código abierto y está disponible para uso educativo.
