# Şehirlerin Enerjisi

## Proje Amacı

Bu proje, farklı ülkelerdeki nükleer reaktörlerin konum bilgileri, teknik özellikleri ve olası bir kaza durumundaki etki düzeylerinin analiz edilmesini sağlamaktadır. Sistem, reaktör verilerini PostgreSQL veritabanında saklar, RESTful API ile hizmet sunar ve Swagger arayüzü sayesinde test edilebilir hale gelir.

## Kullanılan Teknolojiler

* Java 17
* Spring Boot 3.5.0
* Spring Data JPA
* PostgreSQL
* Lombok
* Apache Commons CSV
* Springdoc OpenAPI (Swagger UI)

## Kurulum Talimatları

### Gereksinimler

* Java 17+
* Maven
* PostgreSQL

### Veritabanı Ayarları

`application.properties` dosyasında aşağıdaki bilgileri göre ayarladığınızdan emin olun:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Sehirlerin_Enerjisi
spring.datasource.username=postgres
spring.datasource.password=ecememre28
spring.jpa.hibernate.ddl-auto=create
```

> `ddl-auto=create` sadece test ortamı için kullanılmalıdır. Prod ortamında `validate` veya `update` tercih edilmelidir.

### Projeyi Çalıştırma

```bash
mvn clean install
mvn spring-boot:run
```

### Swagger'a Erişim

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

> Swagger yüklenemiyorsa `/v3/api-docs` endpoint'inde hata olup olmadığı kontrol edilmelidir.

## Endpoint Örnekleri

### Tum Impact Verisini Getir

```
GET /api/impact
```

**Örnek Cevap:**

```json
[
  {
    "reactor": {
      "id": 1,
      "name": "Akkuyu 1",
      "country": "Turkey",
      "latitude": 36.167,
      "longitude": 33.501,
      "type": "PWR",
      "thermalPower": 1114,
      "active": false
    },
    "distanceKm": 425.5882284794336,
    "impactScore": 0.1526923440231234,
    "impactLevel": "LOW"
  },
  {
    "reactor": {
      "id": 2,
      "name": "Beaver Valley 1",
      "country": "USA",
      "latitude": 40.65,
      "longitude": -79.753,
      "type": "PWR",
      "thermalPower": 913,
      "active": true
    },
    "distanceKm": 8415.34,
    "impactScore": 0.29341,
    "impactLevel": "LOW"
  }
]
```

## Cevaplar ve Detaylar

### Hatalı Swagger Yükleme Sorunu

* Hata: `Failed to load API definition /v3/api-docs -> 500`
* Çözüm:

  * springdoc versiyonu `2.2.0` olarak sabitlendi.
  * Lombok versiyonu `1.18.30` ve `annotationProcessorPaths` Maven Compiler Plugin'e eklendi.
  * `spring.security.enabled=false` property eklenerek Swagger'a erişimin engellenmesi önlendi.

### Veritabanı Testi

* Örnek veriler `data.sql` veya servis üzerinden POST isteğiyle manuel girilebilir.

## Katkılar

Bu proje TEKNOFEST "Şehirlerin Enerjisi" başvurusu için geliştirilmiştir.
Backend geliştirme: Ecem Nur Özen
Dokümantasyon ve Swagger entegrasyonu: Ecem Nur Özen
