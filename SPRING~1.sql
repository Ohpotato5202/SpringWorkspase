SELECT
         BOARD_NO,
         BOARD_TITLE,
         USER_NAME AS BOARD_WRITER,
         CREATE_DATE,
         COUNT
      FROM BOARD B
      LEFT JOIN MEMBER M ON BOARD_WRITER = USER_NO
      WHERE B.STATUS = 'Y' 