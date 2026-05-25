# 🌤️ Weather API — Spring Boot

A clean, production-ready RESTful Weather API built with Spring Boot 3.5, using the OpenWeatherMap API to fetch real-time weather data by city name or geographic coordinates.

---

## 🚀 Tech Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 3.5.x |
| Spring Web | RestClient |
| Lombok | Latest |
| Validation | Jakarta |
| Build Tool | Maven |
| Config Format | YAML |

---

## 📁 Project Structure

```
com.app.weather_api
│
├── config
│   └── AppConfig.java          # RestClient bean configuration
│
├── controller
│   └── WeatherController.java  # REST endpoints
│
├── dto
│   └── WeatherResponse.java    # API response mapping
│
├── exception
│   └── GlobalExceptionHandler.java  # Global error handling
│
├── service
│   └── WeatherService.java     # Business logic & API calls
│
└── WeatherApiApplication.java  # Main entry point
```

---

## ⚙️ Configuration

In `src/main/resources/application.yaml`:

```yaml
server:
  port: 8080

weather:
  api:
    key: your_api_key_here
    base-url: https://api.openweathermap.org/data/2.5/weather
    units: metric
```

> 🔑 Replace `your_api_key_here` with your API key from [OpenWeatherMap](https://openweathermap.org/api)

---

## 📡 API Endpoints

### Get Weather by City Name

```
GET /api/weather?city={cityName}
```

**Example:**
```
GET http://localhost:8080/api/weather?city=Cairo
```

**Response:**
```json
{
  "name": "Cairo",
  "main": {
    "temp": 32.5,
    "feels_like": 31.0,
    "temp_min": 30.0,
    "temp_max": 34.0,
    "humidity": 40,
    "pressure": 1012
  },
  "wind": {
    "speed": 3.5
  },
  "weather": [
    {
      "main": "Clear",
      "description": "clear sky",
      "icon": "01d"
    }
  ],
  "sys": {
    "country": "EG"
  }
}
```

---

### Get Weather by Coordinates

```
GET /api/weather/coordinates?lat={latitude}&lon={longitude}
```

**Example:**
```
GET http://localhost:8080/api/weather/coordinates?lat=30.06&lon=31.24
```

---

## ❌ Error Handling

All errors return a consistent JSON structure:

```json
{
  "timestamp": "2026-05-25T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "City not found, please check the city name and try again"
}
```

| Scenario | HTTP Status |
|---|---|
| City not found / wrong name | `404 Not Found` |
| Missing required parameter | `400 Bad Request` |
| Blank city name | `400 Bad Request` |
| Unexpected server error | `500 Internal Server Error` |

---

## ▶️ Running the App

```bash
mvn spring-boot:run
```

Or run directly from your IDE by executing `WeatherApiApplication.java`.

The app will start on: `http://localhost:8080`

---

## 🧪 Testing with Postman

### By City
```
GET http://localhost:8080/api/weather?city=Cairo
GET http://localhost:8080/api/weather?city=London
GET http://localhost:8080/api/weather?city=Tokyo
```

### By Coordinates
```
GET http://localhost:8080/api/weather/coordinates?lat=30.06&lon=31.24
GET http://localhost:8080/api/weather/coordinates?lat=51.50&lon=-0.12
```

### Validation Tests
```
GET http://localhost:8080/api/weather?city=
GET http://localhost:8080/api/weather/coordinates?lat=&lon=
GET http://localhost:8080/api/weather?city=InvalidCityXYZ
```

---

## 📦 Dependencies (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
</dependencies>
```

---

## 🌍 External API

This project uses the **OpenWeatherMap Current Weather API**:

- **Docs:** https://openweathermap.org/current
- **Free tier:** 60 calls/minute, 1,000,000 calls/month
- **Units:** `metric` (°C), `imperial` (°F), `standard` (Kelvin)

---

## 👨‍💻 Author

Built with ❤️ using Spring Boot 3.5 and Java 21.

---

## Project URL

https://roadmap.sh/projects/weather-api-wrapper-service
