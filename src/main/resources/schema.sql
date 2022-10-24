DROP TABLE IF EXISTS PRICES;
DROP TABLE IF EXISTS `GROUP`;
CREATE TABLE `GROUP` (
                         GROUP_ID LONG PRIMARY KEY,
                         GROUP_NAME VARCHAR2(10) NOT NULL
);
CREATE TABLE PRICES (
                        ID LONG PRIMARY KEY AUTO_INCREMENT,
                        BRAND_ID LONG NOT NULL,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE TIMESTAMP NOT NULL,
                        PRICE_LIST INT NOT NULL,
                        PRODUCT_ID LONG NOT NULL,
                        PRIORITY INT4 NOT NULL,
                        PRICE DOUBLE NOT NULL,
                        CURR VARCHAR2(5) NOT NULL,
                        CONSTRAINT fk_group FOREIGN KEY (BRAND_ID) references `GROUP`(GROUP_ID)
);
