# Entity: <br/>
1.	hospital: <br/>
      Synonym: medical center <br/>
      Description: The hospital entity represents the table that contains details of hospitals that can order the product stock <br/>
2.	customer: <br/>
      Synonym: Buyer/Consumer <br/>
      Description: The customer entity represents the table that contains details of customers that can order the product stock. <br/>
3.	product_stock: <br/>
      Synonym: Goods, Commodities <br/>
      Description: The Product_stock entity represents the table that contains details of stocks that are supplied to the hospital and the customer. <br/>
4.	supplier: <br/>
      Synonym: seller, provider <br/>
      Description: The supplier entity represents the table that contains details of suppliers that manage the delivery staff and also arrange for the product stock that could be supplied to the hospital and customers. <br/>
5.	delivery_staff: <br/>
Synonym: transporter <br/>
   Description: The delivery_staff entity represents the table that contains details of transporters that deliver the ordered product stock to the hospital and customers. <br/>

## Entity Relationship: <br/>
hospital places_order product_stock :  maxima: many-many minima: zero-zero <br/>
customer orders product_stock: maxima: many-many minima: zero-zero <br/>
supplier supplies product_stock: maxima: one-many minima: one-one <br/>
delivery_staff delivers_to_customer customer: maxima: one-many minima: zero-zero <br/>
delivery_staff delivers_to_hospital hospital: maxima: one-many minima: zero-zero <br/>
supplier manages delivery_staff: maxima: one-many minima: one-one <br/>
<br/>
## Attribute maxima & minima : <br/>
Entity hospital: <br/> 
hospital_id : <br/>
Type: VARCHAR <br/>
Each hospital_id is assigned to one hospital. Each hospital has one hospital_id and it is required <br/>
hospital_name : <br/>
Type: CHAR <br/>
Each hospital has one hospital_name(singular) and it is required. Many hospitals can have same name(not unique) <br/>
hospital_address : <br/>
Type: CHAR <br/>
Each hospital has hospital_address. It is unique and required for delivery of products <br/>
<br/>
Entity customer: <br/>
customer_id : <br/>
Type: VARCHAR <br/>
Each customer_id is assigned to one customer. Each customer has one customer_id and it is required <br/>
customer_name : <br/>
Type: CHAR <br/>
Each customer has one customer_name(singular) and it is required. Many customers can have same name(not unique) <br/>
customer_address : <br/>
Type: CHAR <br/>
Each customer has customer_address. It is unique and required for delivery of products <br/>
customer_age: <br/>
Type: INT <br/>
It is not unique but singular and optional <br/>
<br/>
Entity product_stock: <br/>
product_id : <br/>
Type: VARCHAR <br/>
Each product_id is assigned to one product. Each product has one product_id and it is required <br/>
product_name : <br/>
Type: CHAR <br/>
Each product has one product_name.  Each product_name is assigned to one product and it is required <br/>
available_quantity : <br/>
Type: INT <br/>
The quantity of stocks that are currently available <br/>
supplier_id: <br/>
Type: VARCHAR <br/>
Each supplier_id is assigned to one hospital. Each supplier has one supplier_id and it is required <br/>
<br/>
Enitiy supplier: <br/>
supplier_id: <br/>
Type: VARCHAR <br/>
Each supplier_id is assigned to one hospital. Each supplier has one supplier_id and it is required <br/>
supplier_name : <br/>
Type: CHAR <br/>
Each supplier has one supplier_name(singular) and it is required. Many suppliers can have same name(not unique) <br/>
delivery_id : <br/>
Type: VARCHAR <br/>
Each delivery_id is assigned to one delivery package. Each delivery package has one delivery_id and it is required <br/>
<br/>
Enitiy delivery_staff: <br/>
delivery_id : <br/>
Type: VARCHAR <br/>
Each delivery_id is assigned to one delivery package. Each delivery package has one delivery_id and it is required <br/>
hospital_id : <br/>
Type: VARCHAR <br/>
Each hospital_id is assigned to one hospital. Each hospital has one hospital_id and it is required <br/>
customer_id : <br/>
Type: VARCHAR <br/>
Each customer_id is assigned to one customer. Each customer has one customer_id and it is required <br/>
delivery_staff_id : <br/>
Type: VARCHAR <br/>
Each delivery_staff_id is assigned to one delivery agent. Each delivery agent has one delivery_staff_id and it is required <br/>
delivery_date : <br/>
Type: DATE <br/>
Each delivery has one date(singular) on which it needs to be delivered and it is required. Many deliveries can have same delivery_date (not unique)
supplier_id: <br/>
Type: VARCHAR <br/>
Each supplier_id is assigned to one hospital. Each supplier has one supplier_id and it is required <br/><br/>

## Dependent and Independent entities:<br/>
a.Independent entities:<br/>
customer<br/>
hospital<br/>
supplier<br/>
b.Dependent entities:<br/>
product_stock<br/>
delivery_staff<br/>

## Dependent relationships<br/>
supplier-manages-delivery_staff<br/>
supplier_supplies_product_stock<br/>
</br>

## Cascade and restrict actions for dependency relationships:</br>
Foreign keys that implement dependency relationships usually have the following referential integrity actions: </br>
Cascade on primary key update and delete </br>
Restrict on foreign key insert and update </br>
</br>
1. supplier-manages-delivery_staff</br>
Cascade on PK:delivery_id update and delete </br>
Restrict on FK:delivery_id insert and update</br>
2. supplier_supplies_product_stock</br>
Cascade on PK:product_id update and delete </br>
Restrict on FK:product_id insert and update</br>
</br>

