$loginBody = @{
    email = "carlos.almeida@exemplo.com"
    password = "senhaPadrao123"
} | ConvertTo-Json

try {
    $loginRes = Invoke-RestMethod -Uri "http://localhost:8080/api/auth/login" -Method Post -Body $loginBody -ContentType "application/json"
    $token = $loginRes.token
    Write-Output "LOGIN SUCCESSFUL. Token length: $($token.Length)"

    $cardapios = Invoke-RestMethod -Uri "http://localhost:8080/api/cardapios" -Method Get -Headers @{ Authorization = "Bearer $token" }
    Write-Output "GET /api/cardapios RESPONSE:"
    $cardapios | ConvertTo-Json -Depth 5
} catch {
    Write-Output "ERROR DETAILS:"
    Write-Output $_
    Write-Output $_.ScriptStackTrace
}
