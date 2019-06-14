SELECT * FROM classicmodels.customers;
UPDATE customers SET addressLine2='Level 2' WHERE customerNumber = '103'; 
DELETE FROM `classicmodels`.`customers` WHERE `customerNumber`='103';
INSERT INTO `classicmodels`.`customers` (`customerNumber`, `customerName`, `contactLastName`, `contactFirstName`, `phone`, `addressLine1`, `city`, `postalCode`, `country`, `salesRepEmployeeNumber`, `creditLimit`) VALUES ('105', 'HoangNgocCoffe', 'Ngoc', 'Hoang', '0839988523', '207 Huynh Thuc Khang', 'Hue', '52025', 'Viet Nam', '1222', '100000.00');
