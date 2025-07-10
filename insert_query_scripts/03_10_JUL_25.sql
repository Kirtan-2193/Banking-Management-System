--
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('a85605ac-e600-40ee-8f8f-434cdab81cc5', 'USER_REGISTER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('2fd4efa3-3048-4abc-952d-f27dd588e84d', 'USER_LOGIN', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('d29f4652-384e-4d15-9d2f-db996ab4d75f', 'USER_LOGOUT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('e573b554-ed42-4298-b36b-1498297b8994', 'ASSIGN_ROLES', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('9e73d112-f463-46be-a6e4-982d64e6050e', 'USER_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('06c8a27c-937e-4898-8931-4826dc8490c1', 'USER_UPDATE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('5b276aae-8688-4100-b936-5a287797790e', 'USER_DELETE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('8f527ca8-de9a-4afd-b19d-4b1d3f5597d1', 'USER_LIST', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'ACCOUNT_CREATE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'ACCOUNT_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('e2993328-7e81-4fb4-8332-b16c679ef406', 'ACCOUNT_UPDATE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('19f464fa-32fc-4cfb-9366-bb28f456ff0d', 'ACCOUNT_DELETE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('005b330e-1f46-44e7-a9c5-1449b3828405', 'TRANSACTION_DEPOSIT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('17495122-444e-4919-a11d-4e315d63dec7', 'TRANSACTION_WITHDRAW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('66805dc7-4fcc-49a5-85b8-83e06f273701', 'TRANSACTION_TRANSFER', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('1610cec2-b03e-4d1d-9584-bec144e0c59d', 'TRANSACTION_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('cc0188a4-1e8c-48d0-95ce-1d88ee6be26e', 'LOAN_APPLY', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('914bc00f-a8f1-48e4-8e2e-e32e38c7758b', 'LOAN_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'LOAN_APPROVE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('985b5b05-8387-4599-a02c-47058dc7b1d1', 'LOAN_REJECT', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('878e3ec9-91f0-4f09-a5cc-3cdeb56ba70c', 'LOAN_STATUS_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('7433db0e-6ba1-4b44-b6a8-0a1f953c36ea', 'AUDIT_LOG_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('ac99522e-82fb-4cfd-928c-f7dfcedc4a82', 'AUDIT_TRANSACTION_REVIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'SUPPORT_TICKET_CREATE', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('8c015fc9-70a7-43c4-ac63-3014ba0a61bb', 'SUPPORT_TICKET_VIEW', 'ACTIVE');
INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'SUPPORT_TICKET_UPDATE', 'ACTIVE');




--
-- Data for Name: role_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('7e46b8f5-b616-4092-ae31-5d2938f7c7a5', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'a85605ac-e600-40ee-8f8f-434cdab81cc5', 'ACTIVE'); -- USER_REGISTER (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('5a12baa6-3522-40ef-b2d7-993e5efc77d6', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '2fd4efa3-3048-4abc-952d-f27dd588e84d', 'ACTIVE'); -- USER_LOGIN (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('40b8d5f7-1dd3-4283-aefc-7c52e34ac866', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'd29f4652-384e-4d15-9d2f-db996ab4d75f', 'ACTIVE'); -- USER_LOGOUT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('e21b7376-4964-424e-ba54-e3b8347c5c6d', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'e573b554-ed42-4298-b36b-1498297b8994', 'ACTIVE'); -- ASSIGN_ROLES (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('364349f8-6b44-45c5-9259-31c54c5dec38', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '9e73d112-f463-46be-a6e4-982d64e6050e', 'ACTIVE'); -- USER_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('a2e21f17-f73f-4ec2-9876-dde74495cae6', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '06c8a27c-937e-4898-8931-4826dc8490c1', 'ACTIVE'); -- USER_UPDATE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('0593292e-f621-45fe-8757-d7d5adebd85b', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '5b276aae-8688-4100-b936-5a287797790e', 'ACTIVE'); -- USER_DELETE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('391e8674-5433-44ba-9208-8ba1eeff3250', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '8f527ca8-de9a-4afd-b19d-4b1d3f5597d1', 'ACTIVE'); -- USER_LIST (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('25629c41-327d-473c-a032-e3f1cfe4932f', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'ACTIVE'); -- ACCOUNT_CREATE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d79fbe3a-54dd-4c18-a470-b52fa57990ce', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'ACTIVE'); -- ACCOUNT_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('46d5fbaa-129a-449e-82e6-ef9ae3e76ac5', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'e2993328-7e81-4fb4-8332-b16c679ef406', 'ACTIVE'); -- ACCOUNT_UPDATE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('12b004d3-49a4-4f4e-8f8d-6b853e75e235', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '19f464fa-32fc-4cfb-9366-bb28f456ff0d', 'ACTIVE'); -- ACCOUNT_DELETE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d59efa19-a302-4e6b-9529-59e71816d43d', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '005b330e-1f46-44e7-a9c5-1449b3828405', 'ACTIVE'); -- TRANSACTION_DEPOSIT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('5e742789-c190-4573-9281-63c0ceae9f14', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '17495122-444e-4919-a11d-4e315d63dec7', 'ACTIVE'); -- TRANSACTION_WITHDRAW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('83a0c2c9-e283-49cc-ad0a-cac78af6e378', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '66805dc7-4fcc-49a5-85b8-83e06f273701', 'ACTIVE'); -- TRANSACTION_TRANSFER (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('807aaa34-98d6-4474-a229-004e8ef6444a', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '1610cec2-b03e-4d1d-9584-bec144e0c59d', 'ACTIVE'); -- TRANSACTION_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('0ceb5a62-e76f-4511-bed6-fd406e733f0c', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'cc0188a4-1e8c-48d0-95ce-1d88ee6be26e', 'ACTIVE'); -- LOAN_APPLY (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('5818b17b-26cc-4c25-8820-22cb53567111', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '914bc00f-a8f1-48e4-8e2e-e32e38c7758b', 'ACTIVE'); -- LOAN_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('b5aa432d-ac92-4fba-a745-13e2c8ec2465', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'ACTIVE'); -- LOAN_APPROVE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('c672aaf9-e601-459e-ae7a-a37b0c726b65', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '985b5b05-8387-4599-a02c-47058dc7b1d1', 'ACTIVE'); -- LOAN_REJECT (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('c810dc72-6a2e-49ee-8f11-8280078cc648', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '878e3ec9-91f0-4f09-a5cc-3cdeb56ba70c', 'ACTIVE'); -- LOAN_STATUS_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('216d9814-106a-4056-a1ac-b8e38f43a48a', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '7433db0e-6ba1-4b44-b6a8-0a1f953c36ea', 'ACTIVE'); -- AUDIT_LOG_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('890a1c1c-2756-4e40-888a-efb2adb2d8e3', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'ac99522e-82fb-4cfd-928c-f7dfcedc4a82', 'ACTIVE'); -- AUDIT_TRANSACTION_REVIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d7c5229c-ad18-4204-ad30-700cbe15a86c', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'ACTIVE'); -- SUPPORT_TICKET_CREATE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('f359b5ba-d2bb-458d-a8c8-7fdcf4f90479', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '8c015fc9-70a7-43c4-ac63-3014ba0a61bb', 'ACTIVE'); -- SUPPORT_TICKET_VIEW (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('2746ab89-6a46-468e-8128-645cc664b498', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'ACTIVE'); -- SUPPORT_TICKET_UPDATE (Admin)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('b2687882-8629-4c62-97d2-11f591e6c938', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '9e73d112-f463-46be-a6e4-982d64e6050e', 'ACTIVE'); -- USER_VIEW (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('3a788939-62e3-490e-8dba-5a7eaabe350f', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '8f527ca8-de9a-4afd-b19d-4b1d3f5597d1', 'ACTIVE'); -- USER_LIST (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('83b0162e-5622-44a6-b479-ad2309581b03', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'ACTIVE'); -- ACCOUNT_VIEW (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('f0d68fd4-8dc0-4bb3-a1d2-0ee75ccdb94c', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', 'e2993328-7e81-4fb4-8332-b16c679ef406', 'ACTIVE'); -- ACCOUNT_UPDATE (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('850483cf-ddc1-468b-af76-1012a607fc16', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'ACTIVE'); -- ACCOUNT_CREATE (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('4039b302-902e-4bc3-9735-bdceff875baa', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '1610cec2-b03e-4d1d-9584-bec144e0c59d', 'ACTIVE'); -- TRANSACTION_VIEW (Manager)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('1b9ef739-56f1-499b-88b4-a0846e8263aa', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '302b4dbf-692c-4ec6-94b4-0cbcc1db1010', 'ACTIVE'); -- ACCOUNT_CREATE (Teller)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d518ae92-ac4e-4254-9095-820bef4f7af5', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'ACTIVE'); -- ACCOUNT_VIEW (Teller)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('fc765f67-5938-4f94-aac1-fe8ef13513f5', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '005b330e-1f46-44e7-a9c5-1449b3828405', 'ACTIVE'); -- TRANSACTION_DEPOSIT (Teller)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('16b20a5e-d3fe-4f13-9ea1-8207341ccb5d', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '17495122-444e-4919-a11d-4e315d63dec7', 'ACTIVE'); -- TRANSACTION_WITHDRAW (Teller)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('ac4f368a-14c9-45b6-becd-decf73baaea1', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '1610cec2-b03e-4d1d-9584-bec144e0c59d', 'ACTIVE'); -- TRANSACTION_VIEW  (Teller)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('06065f36-5a98-4fc3-b3cb-8cbbeab9990c', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '2fd4efa3-3048-4abc-952d-f27dd588e84d', 'ACTIVE'); -- USER_LOGIN (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('02752af1-770f-4beb-b898-0ad767a2a5c0', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'd29f4652-384e-4d15-9d2f-db996ab4d75f', 'ACTIVE'); -- USER_LOGOUT (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('43197db6-de39-4d59-9da1-6477315a273a', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '0ff79fd9-8237-4eaa-8f32-8f92f9756f47', 'ACTIVE'); -- ACCOUNT_VIEW (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('d6f80828-94a5-470d-a7ba-bb19c52dc1b0', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '1610cec2-b03e-4d1d-9584-bec144e0c59d', 'ACTIVE'); -- TRANSACTION_VIEW (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('29f85d6a-0928-4b1b-b1df-b17c124e5125', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '66805dc7-4fcc-49a5-85b8-83e06f273701', 'ACTIVE'); -- TRANSACTION_TRANSFER (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('3cd9c1be-9512-4b3e-bc71-e9ca87371918', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'cc0188a4-1e8c-48d0-95ce-1d88ee6be26e', 'ACTIVE'); -- LOAN_APPLY (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('da924bc9-b57d-42d3-ac66-1ad2c859c463', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '878e3ec9-91f0-4f09-a5cc-3cdeb56ba70c', 'ACTIVE'); -- LOAN_STATUS_VIEW (Customer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('7deddde1-08b1-467a-b951-5da94f9099c2', '90op9021-cde6-4f42-93e5-7gh673z4uvw5', '7433db0e-6ba1-4b44-b6a8-0a1f953c36ea', 'ACTIVE'); -- AUDIT_LOG_VIEW (Auditor)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('56709cee-ea4b-43a2-b6b7-9880b51d8877', '90op9021-cde6-4f42-93e5-7gh673z4uvw5', 'ac99522e-82fb-4cfd-928c-f7dfcedc4a82', 'ACTIVE'); -- AUDIT_TRANSACTION_REVIEW (Auditor)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('6f07b493-66fc-4934-adfe-be5ad74a6c3c', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', '914bc00f-a8f1-48e4-8e2e-e32e38c7758b', 'ACTIVE'); -- LOAN_VIEW (Loan Officer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('b3371d0e-277b-4c5d-90ad-fbf03853b6e4', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', 'f54cbe41-eaa1-40ea-9df1-928def61e2c7', 'ACTIVE'); -- LOAN_APPROVE (Loan Officer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('9daefeba-ae9f-4709-b057-5c34fe9f5cb0', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', '985b5b05-8387-4599-a02c-47058dc7b1d1', 'ACTIVE'); -- LOAN_REJECT (Loan Officer)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('a557bde5-7bf2-4ad6-bf32-844ab7ae5c10', '67st7689-efg8-4h64-95g7-9kl015b6abc7', '995b6470-2f65-41af-9ca3-2b772bc3e7b5', 'ACTIVE'); -- SUPPORT_TICKET_CREATE (Support Staff)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('a85877ca-73ca-423b-a3f2-bb7b9e0a76db', '67st7689-efg8-4h64-95g7-9kl015b6abc7', '8c015fc9-70a7-43c4-ac63-3014ba0a61bb', 'ACTIVE'); -- SUPPORT_TICKET_VIEW (Support Staff)
INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('9da3a63f-4ece-4a74-96eb-0a622b5cfbe4', '67st7689-efg8-4h64-95g7-9kl015b6abc7', '4ab914f1-6307-441b-b363-7bdfb3c2eb83', 'ACTIVE'); -- SUPPORT_TICKET_UPDATE (Support Staff)
