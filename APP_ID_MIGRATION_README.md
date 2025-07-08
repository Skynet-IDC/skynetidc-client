# App ID Migration

This document describes the changes made to add the `app_id` column to the `gb_package` table and clone existing rows with a different app_id.

## Changes Made

1. Added `app_id` column to the `gb_package` table with a default value of 1
2. Cloned all existing rows and set `app_id=2` for the cloned rows
3. Updated the Package entity to include the `app_id` field
4. Updated the PackageRepository methods to consider the `app_id` field:
   - `findAllActivePackage` now accepts an optional `appId` parameter
   - `findById` now accepts an optional `appId` parameter
   - `findByProductId` now accepts an optional `appId` parameter

## How to Run the Migration

Two scripts have been created to perform the migration:

1. SQL Script: `add_app_id_to_package.sql`
   - This script can be run directly on the database using a SQL client

2. JavaScript Script: `add_app_id_to_package.js`
   - This script can be run using Node.js: `node add_app_id_to_package.js`
   - It connects to the database using the same configuration as the application
   - It executes the SQL operations to add the `app_id` column and clone the rows
   - It verifies the changes by querying the database and displaying the results

## Using the app_id Field

After the migration, you can use the `app_id` field to filter packages by app:

```javascript
// Get packages for app_id=1
const packages1 = await PackageRepository.findAllActivePackage({ appId: 1 });

// Get packages for app_id=2
const packages2 = await PackageRepository.findAllActivePackage({ appId: 2 });

// Get a specific package by id and app_id
const package = await PackageRepository.findById(123, 1);

// Get a package by product ID and app_id
const package = await PackageRepository.findByProductId('product_123', 1, 2);
```

If no `appId` is provided, the methods will return packages regardless of their `app_id`.