CREATE DATABASE jdbc_ex;

# 사용자 준비
CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex';

# jdbc_ex를 사용할 수 있는 권한
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%';
# 사용자의 권한 테이블을 다시 로드
FLUSH PRIVILEGES;
