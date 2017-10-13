# SEP_online_shop

Current DB structure (just the tables ive changed)

item_tbl
  - item_id (int) PK
  - item_name (String)
  - item_description (String)
  - stock (int)
  - item_status (int)
  - price (double)
  - image (String)
  - owner_id (int)

user_tbl
  - user_id (int) PK
  - user_name (String)
  - user_password (String)
  - login_status (?) unchanged
  - user_email (String)
