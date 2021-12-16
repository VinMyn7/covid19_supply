CREATE INDEX NameIndex
ON hospital(hospital_name);

CREATE INDEX AddressIndex
ON customer(customer_address);

CREATE INDEX HospitalOrderIndex
ON hospital_order(product_quantity);

CREATE INDEX CustomerOrderIndex
ON customer_order(product_quantity);

CREATE INDEX SupplierIndex
ON supplier(supplier_id);

CREATE INDEX NameIndex
ON product_stock(product_name);

CREATE INDEX DeliveryIndex
ON delivery_staff(delivery_id);