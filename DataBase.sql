CREATE TABLE users (
    userId SERIAL PRIMARY KEY,
    userName VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE roles (
    roleId SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);


CREATE TABLE user_roles (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(userId) ON DELETE CASCADE,
    role_id INT REFERENCES roles(roleId) ON DELETE CASCADE
);


CREATE TABLE projects (
    projectId SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    status VARCHAR(20) DEFAULT 'Active',
    created_by INT REFERENCES users(userId) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);


CREATE TABLE project_members (
	id SERIAL PRIMARY KEY,
    project_id INT REFERENCES projects(projectId) ON DELETE CASCADE,
    user_id INT REFERENCES users(userId) ON DELETE CASCADE
);


CREATE TABLE tasks (
    taskId SERIAL PRIMARY KEY,
    project_id INT REFERENCES projects(projectId) ON DELETE CASCADE,
    assigned_to INT REFERENCES users(userId) ON DELETE SET NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    priority VARCHAR(20), -- E.g., 'High', 'Medium', 'Low'
    status VARCHAR(20) DEFAULT 'To Do', -- E.g., 'In Progress', 'Completed'
	storyPoint Int,
    due_date DATE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);


CREATE TABLE comments (
    commentId SERIAL PRIMARY KEY,
    task_id INT REFERENCES tasks(taskId) ON DELETE CASCADE,
    user_id INT REFERENCES users(userId) ON DELETE SET NULL,
    comment_text TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);


CREATE TABLE file_attachments (
    id SERIAL PRIMARY KEY,
    task_id INT REFERENCES tasks(taskId) ON DELETE CASCADE,
    file_name VARCHAR(255),
    file_path TEXT,
    uploaded_by INT REFERENCES users(userId) ON DELETE SET NULL,
    uploaded_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE activity_logs (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(userId) ON DELETE SET NULL,
    action VARCHAR(255),
    entity_type VARCHAR(50), -- E.g., 'Task', 'Project'
    entity_id INT,
    created_at TIMESTAMP DEFAULT NOW()
);


INSERT INTO roles(roleid, name) VALUES (1,'Admin');

INSERT INTO roles(roleid, name) VALUES (2,'Project Manager');

INSERT INTO roles(roleid, name) VALUES (3,'Team Member');