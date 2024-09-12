
BEGIN
    FOR I IN 1..1000
    LOOP
        INSERT INTO BOARD VALUES 
        (SEQ_BNO.NEXTVAL , '일반게시글' || I , '게시글내용' || I,'N',1, DEFAULT, DEFAULT, DEFAULT);
    END LOOP;
END;
/

COMMIT;