Bai10
The broken pipeline

Ý tưởng:

- `pom.xml`: Logback `9.9.9` không tồn tại; Surefire `2.12.4` không chạy JUnit 5. Đổi sang Logback `1.4.11` và Surefire `3.6.0`.
- `.github/workflows/bai10.yml`: YAML gộp `name` với `on`, nên GitHub không đọc được workflow.
- Lỗi thứ tư: `type.equals(...)` gây NullPointerException với loại hàng `null`; so sánh bằng hằng số và kiểm thử ngoại lệ.
- Vị trí bản sửa: `pom.xml`, `.github/workflows/bai10.yml`, `src/main/java/com/lab/ShippingCalculator.java`.
- Chạy `./run.sh` để xác minh bản sửa. [Lỗi Logback](https://github.com/binhgt39-sudo/GiangThanhBinh_Week9/actions/runs/42466412628), [Surefire 0 test](https://github.com/binhgt39-sudo/GiangThanhBinh_Week9/actions/runs/42466553621), [Surefire 5/5 test](https://github.com/binhgt39-sudo/GiangThanhBinh_Week9/actions/runs/42466612166), [workflow YAML sai](https://github.com/binhgt39-sudo/GiangThanhBinh_Week9/actions/runs/42466739018), [lỗi null](https://github.com/binhgt39-sudo/GiangThanhBinh_Week9/actions/runs/42466853019), [bản sửa cuối](https://github.com/binhgt39-sudo/GiangThanhBinh_Week9/actions/runs/42467010310).
