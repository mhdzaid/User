create table jitpay_user (user_id uuid not null, email varchar(255) not null unique, first_name varchar(255), second_name varchar(255), created_on timestamp, primary key (user_id));