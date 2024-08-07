CREATE TABLE tn_role (
   id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
   "name" varchar(100) NULL,
   created_at timestamp(0) NULL DEFAULT now(),
   updated_at timestamp(0) NULL DEFAULT now(),
   CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE tn_user (
   id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
   email varchar(100) NULL,
   username varchar(100) NULL,
   "password" varchar(200) NULL,
   created_at timestamp(0) NULL DEFAULT now(),
   updated_at timestamp(0) NULL DEFAULT now(),
   CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE tn_user_role (
   user_id int8 NOT NULL,
   role_id int8 NOT NULL,
   created_at timestamp(0) NULL DEFAULT now(),
   updated_at timestamp(0) NULL DEFAULT now(),
   CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES tn_user(id),
	FOREIGN KEY (role_id) REFERENCES tn_role(id)
);

INSERT INTO tn_role (id, "name") VALUES(1, 'ROLE_USER');
INSERT INTO tn_role (id, "name") VALUES(2, 'ROLE_MODERATOR');
INSERT INTO tn_role (id, "name") VALUES(3, 'ROLE_ADMIN');

INSERT INTO tn_user (id, email, "password", username)
VALUES(1, 'ndtam@abc.vn', '$2a$10$wQyK5ymfXgqz/wnrYFdMOe.EP0QKdd3xIT13qzJZ/t5WjcZmsSJrS', 'ndtam@abc.vn');

INSERT INTO tn_user_role (user_id, role_id) VALUES(1, 1);
