package ru.ekaripov.contactsdb.exceptions;

public class DatabaseEntryNotFoundException extends RuntimeException{
    public DatabaseEntryNotFoundException(){ super("Database entry not found");}
}
