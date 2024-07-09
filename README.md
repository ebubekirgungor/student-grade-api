# Student grade api

## Usage

- Create student

```
POST /api/v1/students
# Example input
{
  "name": "Ali",
  "surname": "Yilmaz",
  "stdNumber": "ABC",
  "grades": [
    {
      "code": "MT101",
      "value": 90
    },
    {
      "code": "PH101",
      "value": 75
    },
    {
      "code": "MT101",
      "value": 70
    }
  ]
}

# The output will be:
{
  "name": "Ali",
  "surname": "Yilmaz",
  "stdNumber": "ABC",
  "grades": [
    {
      "code": "MT101",
      "value": 80
    },
    {
      "code": "PH101",
      "value": 75
    }
  ]
}
```

- Update student
```
PUT /api/v1/students/ABC
# Example input
{
  "name": "Veli",
  "surname": "Durmaz",
  "grades": [
    {
      "code": "MT101",
      "value": 100
    },
    {
      "code": "ABCD101",
      "value": 65
    }
  ]
}

# The output will be:
{
  "name": "Veli",
  "surname": "Durmaz",
  "stdNumber": "ABC",
  "grades": [
    {
      "code": "MT101",
      "value": 90
    },
    {
      "code": "PH101",
      "value": 75
    },
    {
      "code": "ABCD101",
      "value": 65
    }
  ]
}
```
