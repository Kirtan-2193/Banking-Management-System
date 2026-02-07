--
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('9f079d2e-5d83-4039-9246-b13de9986f99', 'VIEW_ROLE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('9e73d112-f463-46be-a6e4-982d64e6050e', 'VIEW_USER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('8c015fc9-70a7-43c4-ac63-3014ba0a61bb', 'VIEW_ALL_USER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'VIEW_ACCOUNT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('7433db0e-6ba1-4b44-b6a8-0a1f953c36ea', 'VIEW_ALL_ACCOUNT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('1610cec2-b03e-4d1d-9584-bec144e0c59d', 'VIEW_TRANSACTION', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'VIEW_ALL_TRANSACTION', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('914bc00f-a8f1-48e4-8e2e-e32e38c7758b', 'VIEW_LOAN', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'VIEW_ALL_LOAN', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('878e3ec9-91f0-4f09-a5cc-3cdeb56ba70c', 'VIEW_LOAN_STATUS', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('a85605ac-e600-40ee-8f8f-434cdab81cc5', 'REGISTER_USER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('06c8a27c-937e-4898-8931-4826dc8490c1', 'UPDATE_USER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('e2993328-7e81-4fb4-8332-b16c679ef406', 'UPDATE_ACCOUNT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'CREATE_ACCOUNT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('5b276aae-8688-4100-b936-5a287797790e', 'DELETE_USER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('19f464fa-32fc-4cfb-9366-bb28f456ff0d', 'DELETE_ACCOUNT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('005b330e-1f46-44e7-a9c5-1449b3828405', 'DEPOSIT_TRANSACTION', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('17495122-444e-4919-a11d-4e315d63dec7', 'WITHDRAW_TRANSACTION', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('66805dc7-4fcc-49a5-85b8-83e06f273701', 'TRANSFER_TRANSACTION', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('cc0188a4-1e8c-48d0-95ce-1d88ee6be26e', 'APPLY_LOAN', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'LOAN_APPROVE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('985b5b05-8387-4599-a02c-47058dc7b1d1', 'LOAN_REJECT', 'ACTIVE');



--
-- Data for Name: role_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('dcc84acb-da73-4445-9a8d-c5adf0f3fc2b', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '9f079d2e-5d83-4039-9246-b13de9986f99', 'ACTIVE'); -- VIEW_ROLE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('89257951-601f-4772-8013-4cb824f186fc', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '9e73d112-f463-46be-a6e4-982d64e6050e', 'ACTIVE'); -- VIEW_USER (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('7933add5-0918-4de5-91e6-e7753e03bae4', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '9e73d112-f463-46be-a6e4-982d64e6050e', 'ACTIVE'); -- VIEW_USER (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('25d0bac1-a4c4-4431-a007-e4dcda0eec68', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'ACTIVE'); -- VIEW_ACCOUNT (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('f3b07cb1-9597-4082-b0f3-e0afa39d03d1', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '7433db0e-6ba1-4b44-b6a8-0a1f953c36ea', 'ACTIVE'); -- VIEW_ALL_ACCOUNT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('05c30a01-e9cd-45fe-98a1-250ac752df22', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '7433db0e-6ba1-4b44-b6a8-0a1f953c36ea', 'ACTIVE'); -- VIEW_ALL_ACCOUNT (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d74b050c-6812-4cbf-9dc8-c0077da3ccb9', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '1610cec2-b03e-4d1d-9584-bec144e0c59d', 'ACTIVE'); -- VIEW_TRANSACTION (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('600687c6-5c1a-4415-9c71-fcb03ad61bda', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'ACTIVE'); -- VIEW_ALL_TRANSACTION (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('258aaa37-59d5-4809-a254-178e97050658', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'ACTIVE'); -- VIEW_ALL_TRANSACTION (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('ee884d38-e3e4-4474-abf0-683b03816394', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'ACTIVE'); -- VIEW_ALL_TRANSACTION (Teller)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('f264439e-b61e-4c97-ae9e-151c66a6dfed', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '914bc00f-a8f1-48e4-8e2e-e32e38c7758b', 'ACTIVE'); -- VIEW_LOAN (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('dd7455ab-0819-44af-86c7-45db93c64412', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'ACTIVE'); -- VIEW_ALL_LOAN (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('feef7624-d1ce-4db2-9c25-b5ff2f319818', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'ACTIVE'); -- VIEW_ALL_LOAN (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('0bd3861a-bd8e-47aa-a1d6-d08c38c49b47', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', '4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'ACTIVE'); -- VIEW_ALL_LOAN (Loan Officer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('81d5dbc3-de83-45a3-9c7e-d6e4857bb38b', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'a85605ac-e600-40ee-8f8f-434cdab81cc5', 'ACTIVE'); -- REGISTER_USER (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('3cba4671-fa6f-451e-bda7-757762f2f73f', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '06c8a27c-937e-4898-8931-4826dc8490c1', 'ACTIVE'); -- UPDATE_USER (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('4c265598-a801-4ef8-a819-87db4cc1e838', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'e2993328-7e81-4fb4-8332-b16c679ef406', 'ACTIVE'); -- UPDATE_ACCOUNT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('740696c3-ac4a-45bf-8d39-63baaf8427c2', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', 'e2993328-7e81-4fb4-8332-b16c679ef406', 'ACTIVE'); -- UPDATE_ACCOUNT (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('028b3e5d-d536-42ad-a948-e3a7720ba43e', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'ACTIVE'); -- CREATE_ACCOUNT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('a0a8c7b0-336e-43ab-a321-d5817b3cbd64', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'ACTIVE'); -- CREATE_ACCOUNT (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('f312d06c-a038-46a2-b8d4-e230749941a9', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '5b276aae-8688-4100-b936-5a287797790e', 'ACTIVE'); -- DELETE_USER (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d46bf1e8-d987-4d7f-8511-b6e490421f31', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '19f464fa-32fc-4cfb-9366-bb28f456ff0d', 'ACTIVE'); -- DELETE_ACCOUNT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('567d4f12-49fb-42db-85c9-065234fc1df4', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '19f464fa-32fc-4cfb-9366-bb28f456ff0d', 'ACTIVE'); -- DELETE_ACCOUNT (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('a310ad90-c407-4c6f-b1d0-8f05c566ed99', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '005b330e-1f46-44e7-a9c5-1449b3828405', 'ACTIVE'); -- DEPOSIT_TRANSACTION (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('365985a6-5812-4fad-8b3f-777a01721468', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '17495122-444e-4919-a11d-4e315d63dec7', 'ACTIVE'); -- WITHDRAW_TRANSACTION (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('21b60068-217a-4f59-b573-450c2a0bb4f5', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '66805dc7-4fcc-49a5-85b8-83e06f273701', 'ACTIVE'); -- TRANSFER_TRANSACTION (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('37ee98c1-4b0b-4a30-ac65-5472a81e226f', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'cc0188a4-1e8c-48d0-95ce-1d88ee6be26e', 'ACTIVE'); -- APPLY_LOAN (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('58e86978-ba4c-45ce-b64f-85bbc21c457b', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'ACTIVE'); -- LOAN_APPROVE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('8fd482e7-0332-43f7-aab4-3372fb924570', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', 'f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'ACTIVE'); -- LOAN_APPROVE (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('92b70dea-ab88-4e82-9105-1a411c821a75', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', 'f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'ACTIVE'); -- LOAN_APPROVE (Loan Officer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('3d68eb4a-e91e-4ccc-9b54-4ed0313a11c2', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '985b5b05-8387-4599-a02c-47058dc7b1d1', 'ACTIVE'); -- LOAN_REJECT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('946f9a8b-0c4a-4b0c-864c-c99f2e6deb2c', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '985b5b05-8387-4599-a02c-47058dc7b1d1', 'ACTIVE'); -- LOAN_REJECT (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('020b6097-e537-4c67-af78-c3ca9a991709', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', '985b5b05-8387-4599-a02c-47058dc7b1d1', 'ACTIVE'); -- LOAN_REJECT (Loan Officer)