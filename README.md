# Detran API

API REST para gerenciamento de candidatos, exames, agendamentos de exame e resultados.

## Justificativa do dominio

O dominio escolhido simula um fluxo comum de um departamento de transito: candidatos se cadastram, exames sao disponibilizados, agendamentos sao criados e resultados sao registrados. O dominio permite demonstrar relacionamentos entre entidades, DTOs para entrada/saida da API e regras de autorizacao por perfil.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Security
- Bean Validation
- H2 Database

## Usuarios de teste

| Usuario | Senha | Role |
| --- | --- | --- |
| `admin` | `admin123` | `ROLE_ADMIN` |
| `examiner` | `examiner123` | `ROLE_EXAMINER` |
| `attendant` | `attendant123` | `ROLE_ATTENDANT` |

## Matriz de permissoes

| Endpoint | Metodo | Acesso |
| --- | --- | --- |
| `/api/info` | GET | Publico |
| `/**` listagem/detalhe | GET | `ROLE_ADMIN`, `ROLE_EXAMINER`, `ROLE_ATTENDANT` |
| `/**/{id}` atualizacao | PUT | `ROLE_ADMIN`, `ROLE_EXAMINER` |
| `/**` criacao | POST | `ROLE_ADMIN` |
| `/**/{id}` exclusao | DELETE | `ROLE_ADMIN` |

As regras estao configuradas em `SecurityFilterChain`.

## Status HTTP

- `201 Created`: recurso criado com sucesso.
- `200 OK`: consulta ou atualizacao bem-sucedida.
- `204 No Content`: exclusao bem-sucedida.
- `400 Bad Request`: erro de validacao no DTO de entrada.
- `403 Forbidden`: usuario autenticado sem role necessaria.
- `404 Not Found`: recurso inexistente.

## Exemplos DTO

### CandidateRequest

```json
{
  "name": "Joao Silva",
  "email": "joao.silva@email.com",
  "licenseCategory": "CATEGORYAB"
}
```

### CandidateResponse

```json
{
  "id": 1,
  "name": "Joao Silva",
  "email": "joao.silva@email.com",
  "licenseCategory": "CATEGORYAB"
}
```

### ExamAppointmentRequest

O request usa `examId`, nao a entidade `Exam` inteira.

```json
{
  "examId": 1,
  "date": "2026-05-10",
  "time": "08:30:00",
  "status": "PENDING"
}
```

### ExamAppointmentResponse

```json
{
  "id": 1,
  "examId": 1,
  "date": "2026-05-10",
  "time": "08:30:00",
  "status": "PENDING"
}
```

### ExamResultRequest

```json
{
  "candidateId": 1,
  "examId": 1,
  "result": "PASSED"
}
```

### ExamResultResponse

```json
{
  "id": 1,
  "candidateId": 1,
  "examId": 1,
  "result": "PASSED"
}
```

## Execucao

```bash
./mvnw spring-boot:run
```

H2 Console:

```text
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:detran
User: sa
Password:
```

## Postman

Importe o arquivo:

```text
detran.postman_collection.json
```

A collection usa Basic Auth com `admin/admin123` por padrao.
