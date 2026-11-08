Bai01
Nâng cấp pom.xml cũ (Java 1.8, JUnit 4.10):
Ý tưởng:

-Thêm logback-classic 1.4.11 thay cho System.out.println (dòng 24 - 29).

-Thêm org.hibernate.orm:hibernate-core 6.2.0.Final (từ Hibernate 6 groupId đổi từ org.hibernate) (dòng 31 - 36).

-Xóa junit:junit:4.10, chỉ dùng junit-jupiter 5.9.2 (dòng 17 - 22).