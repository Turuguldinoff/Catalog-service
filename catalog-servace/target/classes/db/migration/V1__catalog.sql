CREATE TABLE public.product_offering(
    id varchar(80) primary key,
    body jsonb,
    last_update timestamp
);
ALTER TABLE public.product_offering
    OWNER to postgres;