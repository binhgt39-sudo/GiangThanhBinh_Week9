# Bai 2 BankSystem Checkstyle

## Tóm tắt

Dự án áp dụng Google Java Style bằng Maven Checkstyle Plugin. Mã nguồn dùng tên hằng số và biến theo quy ước, tài liệu hóa API công khai, tách phần xử lý bản ghi, và dùng `StringBuilder` cho nội dung ghép nhiều dòng. Các thao tác nạp, rút và nhập dữ liệu dùng SLF4J với Logback; lỗi dữ liệu và giao dịch được ghi kèm ngữ cảnh.

## Logging

`INFO` ghi các mốc nghiệp vụ thành công và số lượng khách hàng đã nhập. `WARN` ghi dữ liệu đầu vào không hợp lệ hoặc thiếu để vận hành có thể phát hiện vấn đề mà không làm gián đoạn toàn bộ quá trình nhập. `ERROR` ghi giao dịch thất bại hoặc lỗi I/O, kèm định danh tài khoản, số tiền hay ngoại lệ để hỗ trợ truy vết. `DEBUG` chỉ dùng cho thông tin chi tiết như số giao dịch khi đọc lịch sử. Thông tin tài khoản được giới hạn ở mã tài khoản và số tiền cần xử lý; không ghi tên hay mã định danh khách hàng.

Log sử dụng placeholder `{}` để tránh nối chuỗi trước khi logger cần ghi. Logback mặc định xuất thời gian, mức độ, logger và thông điệp ra console.

## Chạy

Cần có JDK 25 và Maven (mã nguồn được biên dịch theo Java 17). Từ thư mục `Bai02`, chạy `./run.sh`. Để chỉ kiểm tra quy tắc định dạng, chạy `mvn checkstyle:check`; plugin cũng tự chạy ở pha `validate`.
