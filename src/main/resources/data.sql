INSERT INTO users (id, metadata)
VALUES (1, '{
  "active": true,
  "mfa_type": "email"
}' ::jsonb)
ON CONFLICT (id) DO UPDATE SET metadata = EXCLUDED.metadata;

INSERT INTO users (id, metadata)
VALUES (2, '{
  "active": false,
  "mfa_type": "sms"
}' ::jsonb)
ON CONFLICT (id) DO UPDATE SET metadata = EXCLUDED.metadata;