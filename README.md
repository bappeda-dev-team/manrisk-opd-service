# manrisk-opd-service
Service untuk fitur manrisk (OPD)

## Features
- REST API untuk manajemen risiko
- Monitoring dengan Prometheus dan Grafana

## Monitoring
Service ini dilengkapi dengan sistem monitoring menggunakan Prometheus dan Grafana untuk memantau performa aplikasi secara real-time. Untuk informasi lebih lanjut tentang setup monitoring, lihat [MONITORING.md](MONITORING.md).

## Running the Application
Untuk menjalankan aplikasi beserta database dan monitoring tools:

```bash
docker-compose up -d
```

Akses aplikasi di http://localhost:8080
Akses Grafana di http://localhost:3000 (login: admin/admin)
Akses Prometheus di http://localhost:9090

update checklist setiap progress
## Checklist
  - [x] Assigned to developer
  - [x] Spec -> cek SPEC.md
  - [ ] Migrasi
  - [ ] REST API (CRUD)
  - [ ] Logic skala peta risiko
  - [x] Monitoring setup with Prometheus and Grafana
  - [ ] Reviewed
  - [ ] Deployed to staging
  - [ ] Approved by product owner
  - [ ] Deployed to production
