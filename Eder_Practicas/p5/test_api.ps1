# Script de pruebas de API - Medical Management System
# Ejecutar: .\test_api.ps1

Write-Host "=================================" -ForegroundColor Cyan
Write-Host "  API Testing Script" -ForegroundColor Cyan
Write-Host "  Medical Management System" -ForegroundColor Cyan
Write-Host "=================================" -ForegroundColor Cyan
Write-Host ""

$baseUrl = "http://localhost:8000/api"

# Función para hacer peticiones
function Test-Endpoint {
    param(
        [string]$Method,
        [string]$Endpoint,
        [object]$Body = $null,
        [string]$Description
    )
    
    Write-Host "Testing: $Description" -ForegroundColor Yellow
    Write-Host "  $Method $Endpoint" -ForegroundColor Gray
    
    try {
        if ($Body) {
            $jsonBody = $Body | ConvertTo-Json
            $response = Invoke-RestMethod -Uri "$baseUrl/$Endpoint" -Method $Method -Body $jsonBody -ContentType 'application/json'
        } else {
            $response = Invoke-RestMethod -Uri "$baseUrl/$Endpoint" -Method $Method
        }
        
        Write-Host "  ✓ SUCCESS" -ForegroundColor Green
        $response | ConvertTo-Json -Depth 10 | Write-Host -ForegroundColor White
        Write-Host ""
        return $true
    }
    catch {
        Write-Host "  ✗ ERROR: $($_.Exception.Message)" -ForegroundColor Red
        Write-Host ""
        return $false
    }
}

# Contador de pruebas
$total = 0
$passed = 0

# ===== SPECIALTIES =====
Write-Host "`n========== SPECIALTIES ==========" -ForegroundColor Magenta

$total++
if (Test-Endpoint -Method "GET" -Endpoint "specialties" -Description "Get all specialties") { $passed++ }

$total++
if (Test-Endpoint -Method "GET" -Endpoint "specialties/1" -Description "Get specialty by ID") { $passed++ }

$total++
$newSpecialty = @{
    name = "Neurology"
    description = "Brain and nervous system specialist"
}
if (Test-Endpoint -Method "POST" -Endpoint "specialties" -Body $newSpecialty -Description "Create new specialty") { $passed++ }

# ===== DOCTORS =====
Write-Host "`n========== DOCTORS ==========" -ForegroundColor Magenta

$total++
if (Test-Endpoint -Method "GET" -Endpoint "doctors" -Description "Get all doctors") { $passed++ }

$total++
$newDoctor = @{
    name = "Dr. Maria Garcia"
    email = "maria.garcia@hospital.com"
    phone = "+1234567891"
    specialty_id = 1
}
if (Test-Endpoint -Method "POST" -Endpoint "doctors" -Body $newDoctor -Description "Create new doctor") { $passed++ }

# ===== PATIENTS =====
Write-Host "`n========== PATIENTS ==========" -ForegroundColor Magenta

$total++
if (Test-Endpoint -Method "GET" -Endpoint "patients" -Description "Get all patients") { $passed++ }

$total++
$newPatient = @{
    name = "John Smith"
    email = "john.smith@email.com"
    phone = "+0987654322"
    birth_date = "1985-03-20"
    address = "456 Oak Street, City, Country"
}
if (Test-Endpoint -Method "POST" -Endpoint "patients" -Body $newPatient -Description "Create new patient") { $passed++ }

# ===== APPOINTMENTS =====
Write-Host "`n========== APPOINTMENTS ==========" -ForegroundColor Magenta

$total++
if (Test-Endpoint -Method "GET" -Endpoint "appointments" -Description "Get all appointments") { $passed++ }

$total++
$newAppointment = @{
    patient_id = 1
    doctor_id = 1
    appointment_date = "2025-12-20 14:00:00"
    status = "confirmed"
    notes = "Follow-up appointment"
}
if (Test-Endpoint -Method "POST" -Endpoint "appointments" -Body $newAppointment -Description "Create new appointment") { $passed++ }

# Resumen
Write-Host "`n=================================" -ForegroundColor Cyan
Write-Host "  TEST SUMMARY" -ForegroundColor Cyan
Write-Host "=================================" -ForegroundColor Cyan
Write-Host "Total Tests: $total" -ForegroundColor White
Write-Host "Passed: $passed" -ForegroundColor Green
Write-Host "Failed: $($total - $passed)" -ForegroundColor $(if ($total -eq $passed) { "Green" } else { "Red" })
Write-Host "Success Rate: $([math]::Round(($passed / $total) * 100, 2))%" -ForegroundColor $(if ($total -eq $passed) { "Green" } else { "Yellow" })
Write-Host ""

if ($total -eq $passed) {
    Write-Host "✓ ALL TESTS PASSED!" -ForegroundColor Green
} else {
    Write-Host "⚠ SOME TESTS FAILED" -ForegroundColor Yellow
}
