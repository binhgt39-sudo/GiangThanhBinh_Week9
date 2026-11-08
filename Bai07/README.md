Bai07
Automated Code Review via Pull Request

Ý tưởng:

- Pull request vào `main` chạy test, coverage và Checkstyle; reviewdog gửi nhận xét inline.
- Bật branch protection và bắt buộc các check `bai07-verify` và `bai07-checkstyle-review` trước khi merge.
- Tạo pull request có lỗi định dạng để kiểm chứng nhận xét của bot.

Chạy: `./run.sh`
