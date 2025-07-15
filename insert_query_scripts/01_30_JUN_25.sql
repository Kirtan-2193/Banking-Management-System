--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (role_id, role_name, status) VALUES ('hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'Admin', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('78jk1299-dab3-4a27-80b1-4cd991a2klo2', 'Manager', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('12lk4587-abc4-4d19-91c3-5bc231x2opq3', 'Teller', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'Customer', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('23qr3456-def7-4g53-94f6-8ij894a5xyz6', 'Loan Officer', 'ACTIVE');



--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('a1b2c3d4-e5f6-7890-abcd-111122223333', 'john.doe@example.com', 'John', 'MALE', 'Doe', 'password123', '9876543210');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('b2c3d4e5-f6a7-8901-bcde-222233334444', 'jane.smith@example.com', 'Jane', 'FEMALE', 'Smith', 'securePass456', '9876543211');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('c3d4e5f6-a7b8-9012-cdef-333344445555', 'mike.jordan@example.com', 'Mike', 'MALE', 'Jordan', 'myPass789', '9876543212');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('d4e5f6a7-b8c9-0123-def0-444455556666', 'lisa.brown@example.com', 'Lisa', 'FEMALE', 'Brown', 'Lisa@2024', '9876543213');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('f6a7b8c9-d0e1-2345-f012-666677778888', 'emma.wilson@example.com', 'Emma', 'FEMALE', 'Wilson', 'emma1234', '9876543215');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('b8c9d0e1-f2a3-4567-1234-888899990000', 'olivia.jones@example.com', 'Olivia', 'FEMALE', 'Jones', 'Olivia#pass', '9876543217');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('c9d0e1f2-a3b4-5678-2345-999900001111', 'ryan.clark@example.com', 'Ryan', 'MALE', 'Clark', 'RyanC@123', '9876543218');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('d0e1f2a3-b4c5-6789-3456-000011112222', 'sophia.hill@example.com', 'Sophia', 'FEMALE', 'Hill', 'S0phia2025', '9876543219');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('e1f2a3b4-c5d6-7890-4567-111122223333', 'william.green@example.com', 'William', 'MALE', 'Green', 'WillPass!', '9876543220');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('f2a3b4c5-d6e7-8901-5678-222233334444', 'mia.adams@example.com', 'Mia', 'FEMALE', 'Adams', 'Mia_2025', '9876543221');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('a3b4c5d6-e7f8-9012-6789-333344445555', 'james.walker@example.com', 'James', 'MALE', 'Walker', 'JamesW#1', '9876543222');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('b4c5d6e7-f8a9-0123-7890-444455556666', 'chloe.morris@example.com', 'Chloe', 'FEMALE', 'Morris', 'ChloeM@789', '9876543223');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('c5d6e7f8-a9b0-1234-8901-555566667777', 'alex.thomas@example.com', 'Alex', 'MALE', 'Thomas', 'Alex12345', '9876543224');



--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('8ed7441f-ab08-4974-a1e2-1c5a63ce857f', 'ACTIVE', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'a1b2c3d4-e5f6-7890-abcd-111122223333');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('d044f24f-2f45-4d70-a5e0-46b11efbdf59', 'ACTIVE', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', 'b2c3d4e5-f6a7-8901-bcde-222233334444');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('6800c895-619d-4e46-832e-5588b34a655b', 'ACTIVE', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', 'c3d4e5f6-a7b8-9012-cdef-333344445555');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('7d75a2a9-560b-4f5e-b180-1da1978383bd', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'd4e5f6a7-b8c9-0123-def0-444455556666');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('1d775376-fb13-41fd-9d45-03dd3170bb33', 'ACTIVE', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', 'f6a7b8c9-d0e1-2345-f012-666677778888');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('a9f50a15-7f62-41c5-9f36-93f5e5cdfa2e', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'b8c9d0e1-f2a3-4567-1234-888899990000');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('cf5b90a1-dee1-4758-8723-38b2c57e5f09', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'c9d0e1f2-a3b4-5678-2345-999900001111');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('7c969e52-5967-4d5e-97d5-5b17c06691e0', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'd0e1f2a3-b4c5-6789-3456-000011112222');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('9ecaf927-66d7-47b2-bd05-c7b4f2276daf', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'e1f2a3b4-c5d6-7890-4567-111122223333');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('af4bb888-49bb-45aa-8ca5-e09184753a84', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'f2a3b4c5-d6e7-8901-5678-222233334444');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('891f5342-565c-4cd8-aeb8-6db54e6c5036', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'a3b4c5d6-e7f8-9012-6789-333344445555');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('39cbc743-808d-4e09-8e9a-73ef2e038550', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'b4c5d6e7-f8a9-0123-7890-444455556666');
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('c6400cb1-0081-477d-9db3-ee90cfe71930', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'c5d6e7f8-a9b0-1234-8901-555566667777');
