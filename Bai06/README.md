Bai06
CI/CD Pipeline Optimization & Caching

Ý tưởng:

- `setup-java` dùng `cache: maven`; workflow in trạng thái cache.
- Ghi trạng thái cache miss/hit và so sánh thời gian hai lần chạy trong GitHub Actions.

Chạy: `./run.sh`
