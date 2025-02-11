ALTER TABLE todos
    RENAME TO tasks;

ALTER TABLE tasks
    RENAME CONSTRAINT todos_user_id_fkey TO tasks_user_id_fkey;

ALTER INDEX todos_pkey RENAME TO tasks_pkey;

ALTER TABLE tasks
    DROP CONSTRAINT todos_status_check;
ALTER TABLE tasks
    ADD CONSTRAINT tasks_status_check
        CHECK (status IN ('PENDING', 'COMPLETED'));

ALTER SEQUENCE todos_id_seq RENAME TO tasks_id_seq;

