DROP DATABASE IF EXISTS FuneralMatching;

CREATE DATABASE FuneralMatching;

USE FuneralMatching;

# 조의문 테이블
CREATE TABLE condolence(
    id SMALLINT(2) UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `body` TEXT NOT NULL,
    `password` CHAR(10) DEFAULT "0000",
    boardId SMALLINT(2) UNSIGNED NOT NULL DEFAULT 1,
    writer CHAR(10) NOT NULL
);

# 테스트 조의문 삽입

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족1";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족2";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족3";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족4";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족5";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족6";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족7";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족8";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "삼가 고인의 명복을 빕니다",
writer = "유족9";

INSERT INTO condolence
SET regDate = NOW(),
updateDate = NOW(),
`body` = "글자수테스트용본문입니다얼마나길게나올까",
writer = "유족10";

SELECT *
FROM condolence;