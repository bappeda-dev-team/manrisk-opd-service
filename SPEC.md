# Spec manrisk

- [ ] **Define Feature Summary**
  - [ ] Feature name: Manrisk
  - [ ] Service name: Manrisk-Service
  - [ ] description: Backend service untuk manrisk
  - [ ] Goal or outcome: User asn bisa input manrisk, dan user admin dapat melihat rekapnya

- [ ] **Write Context / Background**
  - [ ] Why the feature is needed: Untuk memenuhi kebutuhan laporan manajemen risiko (manrisk) opd.
  - [ ] What user or business problem it solves: Data untuk pemenuhan manajemen risiko dari bppt dan inspektorat daerah
  - [ ] Any related features or legacy concerns: Rencana Kinerja dan Pohon Kinerja

- [ ] **List Business Requirements**
  - [ ] Expected user actions (what can user do?): Create, Update, View
  - [ ] Expected results or outputs: User asn dapat input, update dan melihat hasil input manajemen resiko.
  - [ ] Must-have filters, validations, or restrictions: 
    - [ ] filter: filter by opd dan tahun untuk admin opd. filter by nip untuk asn.
    - [ ] validasi: semua field harus terisi, jika tidak status -> belum lengkap.
    - [ ] restrictions: user asn hanya dapat mengisi manrisk miliknya sendiri.
  - [ ] Logging or audit requirements: -

- [ ] **Define API Contract**
  - [ ] HTTP method and endpoint path
    - `GET /manrisk/{kode_opd}/{tahun}/{id_rekin}`  -- View manrisk by kode_opd, tahun dan id_rekin
    - `GET /manrisk/{kode_opd}/{tahun}`  -- View all manrisk by kode_opd dan tahun 
    - `GET /manrisk/{kode_opd}/{tahun}/{nip_asn}` -- View all manrisk by kode_opd, tahun dan nip asn
    - `POST /manrisk/{kode_opd}/{tahun}/{nip_asn}` -- Input Manrisk
    - `PATCH /manrisk/{kode_opd}/{tahun}/{nip_asn}/{manrisk_id}` -- Update Manrisk
  - [ ] Request body format
    - JSON Body format for POST and PATCH
    ```json
    {
      "id_rekin": "123",
      "nip_asn": "1999999999",
      "kode_opd": "1.29.99.99999",
      "tahun": "2025",
      "penyebab_permasalahan": "Jumlah SDM Bappeda yang terbatas",
      "permasalahan": "Keterlambatan dalam penyusuan dokumen RAT Tahun N+1",
      "pernyataan_risiko": "Jika tidak terussun maka tidak ada panduan dalam penanggulangan kemiskinan pada tahun berikut",
      "skala_kemungkinan": "Jarang",
      "dampak": "Intervensi program penganggulanagan kemiskinan tidak tepat sasaran",
      "skala_dampak": "Tinggi",
      "pihak_yang_terkena": "Pemerintah Kota Madiun",
      "keterangan": "Supaya dilakukan pengendalian",
    }
    ```
  - [ ] Response format (including content type if binary):
    - Response success input | setiap update status manrisk akan kembali ke "MenungguVerifikasiAtasan"
    ```json
    {
      "id": 1,
      "id_rekin": "123",
      "nip_asn": "1999999999",
      "kode_opd": "1.29.99.99999",
      "tahun": "2025",
      "penyebab_permasalahan": "Jumlah SDM Bappeda yang terbatas",
      "permasalahan": "Keterlambatan dalam penyusuan dokumen RAT Tahun N+1",
      "pernyataan_risiko": "Jika tidak terussun maka tidak ada panduan dalam penanggulangan kemiskinan pada tahun berikut",
      "skala_kemungkinan": "Jarang",
      "dampak": "Intervensi program penganggulanagan kemiskinan tidak tepat sasaran",
      "skala_dampak": "Tinggi",
      "skala_peta_risiko": "(B) Level Risiko Sedang",
      "pihak_yang_terkena": "Pemerintah Kota Madiun",
      "keterangan": "Supaya dilakukan pengendalian",
      "status_manrisk": "MenungguVerifikasiAtasan"
      "created_date": "2025-06-03 02:43:50",
      "last_modified_date": "2025-06-03 02:43:50",
      "status": "UNCHECKED",
      "version": 1
    }
    ```
  - [ ] Error handling and codes:
    - semua field pada request body wajib terisi
    - beri keterangan jika field kosong / belum terisi

- [ ] **Identify Service Ownership**
  - [ ] Which microservice handles what
    - manrisk-service: responsible for gathering manrisk data 
    - perencanaan-service: responsible for gathering data rencana kinerja, indikator, target, satuan, anggaran, pelaksana, pokin & pokin atasan
    - pegawai-service: responsible for get pelaksana data (by nip) and determine the atasan for penilaian manrisk
  - [ ] What logic stays within this service:
    - Logic skala peta risiko, hitung dengan kombinasi skala_dampak dan skala_peta_risiko
  - [ ] Delegations to other services (if any):
    - perencanaan-service: handle data rencana kinerja, indikator, target, satuan, anggaran, pelaksana, pokin & pokin atasan

- [ ] **List Integration Points**
  - [ ] Other services involved:
    - perencanaan-service
    - pegawai-service
  - [ ] External APIs or DBs queried
    - none
  - [ ] Auth/permissions service
    - di api gateway

- [ ] **Describe Data Schema Changes** *(if applicable)*
  - [ ] New tables/fields:
    - Table Manrisk: sesuai dengan response field
  - [ ] Sample SQL/DDL
    ```sql
    CREATE TABLE manrisk (
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    id_rekin            VARCHAR(255) NOT NULL,
    nip_asn             VARCHAR(255) NOT NULL,
    kode_opd            VARCHAR(255) NOT NULL,
    tahun               VARCHAR(255) NOT NULL,
    permasalahan        VARCHAR(255) NOT NULL,
    ....
    status_manrisk      VARCHAR(255) NOT NULL,
    version             INTEGER NOT NULL,
    status              VARCHAR(255) NOT NULL,
    created_date        timestamp NOT NULL,
    last_modified_date  timestamp NOT NULL
    );
    ```
  - [ ] Migration strategy:
    - buat database baru
    - gunakan flywaydb untuk java / go
    - gunakan golang migrate untuk go

- [ ] **Add Testing Notes**
  - [ ] Unit test cases
    - Test logic skala_peta_risiko
      - contoh: jika skala_kemungkinan: Jarang dan skala_dampak: Tinggi, maka skala_peta_risiko: (B) Level Risiko Sedang
  - [ ] Integration test cases
    - none
  - [ ] E2E test cases
    - none
  - [ ] Manual QA checklist:
    - pastikan status manrisk kembali ke MenungguVerifikasiAtasan setiap mereka edit dan update manrisk

- [ ] **Add Status Tracking**
  - [x] Assigned to developer
  - [ ] Reviewed by tech lead
  - [ ] Approved by product owner


