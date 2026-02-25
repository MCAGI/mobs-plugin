# Mob Class Directory Structure

All mob implementations must be created within the following standardized package hierarchy. Adhere strictly to this structure to prevent duplicate code and maintain organization.

**Path Pattern:**
`src/main/java/io/github/mcagi/mobs/{default_mob_name}/{custom_type_name}/{version}`

**Variable Definitions:**

- `{default_mob_name}`: The base mob entity (e.g., `zombie`, `skeleton`).
- `{custom_type_name}`: The thematic variant (e.g., `cyberpunk`, `valhalla`, `god`).
- `{version}`: The iteration number (e.g., `1`, `2`, `3`).

**Valid Examples:**

- `src/main/java/io/github/mcagi/mobs/zombie/cyberpunk/1`
- `src/main/java/io/github/mcagi/mobs/zombie/cyberpunk/2`
- `src/main/java/io/github/mcagi/mobs/skeleton/god/1`

**Constraints:**

1. **Path Separators:** Always use forward slashes (`/`) for paths, regardless of the operating system.
2. **Naming Convention:** All package directories must be lowercase.
3. **Duplication Prevention:** Before creating a new mob class, verify that the specific `{default_mob_name}/{custom_type_name}/{version}` combination does not already exist. Do not create redundant versions unless specific functional changes are required.
