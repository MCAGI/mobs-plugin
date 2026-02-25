# Mob Development Protocol

All new mob implementations must adhere to the following Git branching, directory structure, naming conventions, and scope isolation standards. This ensures organization, version control consistency, valid Java syntax, and prevents duplicate code or unintended side effects.

## 1) Request Input Format

When a new mob is requested, the input must strictly follow this structure to ensure accurate parsing of variables.

### Required Format

```text
Mob: {mob name}
Type: {mob type}
Version: {mob version}
```

### Variable Definitions

- {mob name}: The base entity name (lowercase, e.g., zombie, skeleton).
- {mob type}: The thematic variant (lowercase, e.g., cyberpunk, god).
- {mob version}: The iteration number (integer, e.g., 1, 2).

### Example Input

```text
Mob: zombie
Type: cyberpunk
Version: 1
```

## 2) Git Branching Strategy

Before initiating any work, create or switch to a specific feature branch based on the input variables.

### Branch Naming Pattern

`feat/{mob name}-{mob type}-{mob version}`

### Constraints (Branching)

- Case: All characters must be lowercase.
- Separators: Use hyphens (-) only. No spaces or underscores.
- Verification: Check if the branch already exists before creating it.

### Examples (Branch Names)

- ✅ feat/zombie-cyberpunk-1
- ❌ feat/Zombie-Cyberpunk-1 (invalid: uppercase)
- ❌ feat/zombie_cyberpunk_1 (invalid: underscores)

## 3) Strict Scope Isolation

When working on a specific branch, modify files only within the corresponding mob directory.

### Rule

If the branch is `feat/{mob}-{type}-{version}`, you must only create or edit files within:
`src/main/java/io/github/mcagi/mobs/{mob}/{type}/_{version}`

### Prohibited

- Do not modify configuration files, registries, other mob directories, shared utilities, or previous versions of the same mob.

### Goal

- Keep each branch self-contained to prevent merge conflicts and unintended side effects.

### Example (Scope)

- Branch: `feat/zombie-cyberpunk-1`
- Allowed: `src/main/java/io/github/mcagi/mobs/zombie/cyberpunk/_1`
- Restricted: `src/main/java/io/github/mcagi/mobs/zombie/cyberpunk/_2` or any other path.

## 4) Package Directory Structure

All mob class files must be created within the standardized package hierarchy.

### Path Pattern

`src/main/java/io/github/mcagi/mobs/{mob name}/{mob type}/_{mob version}`

### Constraints (Packages)

- Case: All directory names must be lowercase.
- Version directory: Prefix numeric versions with an underscore (e.g., `_1`, `_2`) to ensure valid Java package naming conventions.
- Separators: Use forward slashes (`/`) for all paths, regardless of OS.
- Verification: Check if the directory path already exists before creating it.

### Examples (Paths)

- ✅ `src/main/java/io/github/mcagi/mobs/zombie/cyberpunk/_1`
- ❌ `src\main\java\...` (invalid: backslashes)
- ❌ `.../cyberpunk/1` (invalid: package cannot start with a number)

## 5) Class Naming Convention

The Java class file and the class definition must follow PascalCase naming conventions.

### Naming Pattern

`{Type}{Mob}V{Version}.java`

### Constraints (Classes)

- Case: PascalCase (UpperCamelCase). Convert `{mob type}` and `{mob name}` to capitalized words.
- Matching: The file name must exactly match the public class name.
- Uniqueness: Ensure the class name does not conflict with existing classes in the project.

### Examples (Class Names)

- ✅ `CyberpunkZombieV1.java` (class: `public class CyberpunkZombieV1`)
- ❌ `cyberpunkZombieV1.java` (invalid: lowercase start)
- ❌ `zombie_cyberpunk_1.java` (invalid: snake_case)

## 6) Additive Versioning Policy

New mob versions are additive, not destructive.

### Rules

- No overwrites: Creating a new version (e.g., V2) must never modify, delete, or overwrite an existing version (e.g., V1).
- Parallel existence: Old versions must remain functional and untouched in their respective directories.
- New implementation: Each version is a new class implementation, even if it shares logic with previous versions.

### Example (Additive Policy)

- When creating `feat/zombie-cyberpunk-2`, create `.../cyberpunk/_2/CyberpunkZombieV2.java`.
- Do **not** edit `.../cyberpunk/_1/CyberpunkZombieV1.java`.

## 7) Duplication Prevention Checklist

Before generating any code or branches, verify:

- Input format: Is the request provided in the required Mob/Type/Version format?
- Branch check: Does `feat/{mob}-{type}-{version}` already exist?
- Path check: Does `src/main/java/.../mobs/{mob}/{type}/_{version}` already exist?
- Class check: Does a class with the intended PascalCase name already exist in the codebase?
- Scope check: Am I working strictly within the designated directory for this branch?
- Preservation check: Are all previous versions (e.g., `_1`, V1) left completely untouched?

## 8) Universal Workflow Template

When prompted to create a new mob, apply the following substitution logic to generate the correct structure.

### Execution Steps

1. Parse input: Extract `{mob}`, `{type}`, and `{version}` from the request.
2. Branch: `git checkout -b feat/{mob}-{type}-{version}`.
3. Path: `src/main/java/io/github/mcagi/mobs/{mob}/{type}/_{version}`.
4. Class: `{Type}{Mob}V{Version}.java` (convert `{type}` and `{mob}` to PascalCase for the filename).
5. Package: `io.github.mcagi.mobs.{mob}.{type}._{version}`.

### Concrete Illustration

If requested:

```text
Mob: skeleton
Type: god
Version: 2
```

Generated output:

- Branch: `feat/skeleton-god-2`
- Path: `src/main/java/io/github/mcagi/mobs/skeleton/god/_2`
- File: `GodSkeletonV2.java`

```java
package io.github.mcagi.mobs.skeleton.god._2;

public class GodSkeletonV2 {
    // Implementation
}
```
