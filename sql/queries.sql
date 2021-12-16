#simple views
create view View1
as
select hospital_name from hospital;

create view View2
as
select * from delivery_staff where delivery_id !='DEL345' order by(delivery_date);


#aggregate views
create view View3
as
select delivery_id
from delivery_staff
where delivery_date = curdate()
group by delivery_id
having count(delivery_id)>=1;

create view View4
as
select SUM(available_quantity) from product_stock;


#complex views
create view View5
as
select hospital.hospital_name,customer.customer_name
from hospital
cross join
customer;

create view View6
as
SELECT DISTINCT product_name FROM product_stock
  WHERE EXISTS (SELECT * FROM supplier
                WHERE product_stock.supplier_id = supplier.supplier_id);