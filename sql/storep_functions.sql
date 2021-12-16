#stored procedures
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delivery_count`(IN delivery_date DATE, OUT number_of_deliveries INT)
select COUNT(delivery_id)
from delivery_staff
where delivery_date = curdate()$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Product_availability`(IN available_quantity SMALLINT, OUT quantity SMALLINT)
select product_name,available_quantity
from product_stock
where available_quantity > 0$$
DELIMITER ;

#functions

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `Availability`(name CHAR(20)) RETURNS int
    READS SQL DATA
BEGIN
DECLARE  quant SMALLINT UNSIGNED;
SELECT available_quantity
INTO quant
FROM product_stock
WHERE product_name = name;
RETURN quant;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `OrderQuantity`(id VARCHAR(10)) RETURNS int
    READS SQL DATA
BEGIN
DECLARE ItemsCount SMALLINT UNSIGNED;
SELECT product_quantity 
INTO ItemsCount
FROM hospital_order
WHERE hospital_id = id;
RETURN ItemsCount;
END$$
DELIMITER ;