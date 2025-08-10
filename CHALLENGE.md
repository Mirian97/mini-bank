# EBANX Software Engineer Take-home Assignment

## Requirements

Implement the following API in the simplest way you can.

**Durability IS NOT a requirement** - you don't need to use a database or persistence mechanism.

## API Endpoints

### `GET /balance?account_id={id}`

Returns the balance for the given account ID.

- **Success (200)**: Returns balance as number
- **Not Found (404)**: Returns `0` if account doesn't exist

### `POST /event`

Processes banking events (deposit, withdraw, transfer).

- **Success (201)**: Returns updated account information
- **Not Found (404)**: Returns `0` if account doesn't exist for withdraw/transfer

### `POST /reset`

Resets all account data (for testing purposes).

- **Success (200)**: Returns OK

## Event Types

### Deposit

```json
{ "type": "deposit", "destination": "100", "amount": 10 }
```

Response:

```json
{ "destination": { "id": "100", "balance": 10 } }
```

### Withdraw

```json
{ "type": "withdraw", "origin": "100", "amount": 5 }
```

Response:

```json
{ "origin": { "id": "100", "balance": 15 } }
```

### Transfer

```json
{ "type": "transfer", "origin": "100", "amount": 15, "destination": "300" }
```

Response:

```json
{
  "origin": { "id": "100", "balance": 0 },
  "destination": { "id": "300", "balance": 15 }
}
```

## Test Cases Reference

Based on the automated test suite:

1. **Reset state** - `POST /reset` → `200 OK`
2. **Non-existing account balance** - `GET /balance?account_id=1234` → `404 0`
3. **Create account with deposit** - Creates new account with initial balance
4. **Deposit to existing account** - Adds to existing balance
5. **Get existing account balance** - Returns current balance
6. **Withdraw from non-existing account** - Returns `404 0`
7. **Withdraw from existing account** - Deducts from balance
8. **Transfer between accounts** - Moves money from origin to destination
9. **Transfer from non-existing account** - Returns `404 0`

## Guidelines

- Use your favorite programming language
- Build a system that can handle the requests
- Publish it on the internet
- Separate business logic from HTTP transport layer
- Pay attention to package/directory structure, naming and encapsulation
- Keep code simple - don't anticipate anything not in the spec
- Keep code malleable for potential modifications
- Use version control

## Goal

Create a working API that passes the automated test suite.

## Submission

Submit your solution at: https://app3.greenhouse.io/tests/fd0aaf46df2c91be5b1bb071ef1ad2b6?utm_medium=email&utm_source=TakeHomeTest
