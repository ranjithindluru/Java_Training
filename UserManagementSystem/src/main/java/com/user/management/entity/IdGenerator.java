package com.user.management.entity;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
	
	// This field Atomic increment the Id 
    private AtomicLong currentId;

    public IdGenerator() {
        this.currentId = new AtomicLong(getLastStoredId());
    }

    /**
     * This method generated the id 
     * Atomically increment current value with the memory
     * @return
     */
    public long generateId() {
        return currentId.incrementAndGet();
    }

    /**
     * get the last storeId 
     * @return
     */
    private long getLastStoredId() {
        try {
            File file = new File("data/id.txt");
            if (!file.exists()) {
                file.createNewFile();
                return 0L;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String lastIdStr = reader.readLine();
                if (lastIdStr != null && !lastIdStr.isEmpty()) {
                    return Long.parseLong(lastIdStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    // method the StoreLastId
    public void storeLastId() {
        try {
            File file = new File("data/id.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.valueOf(currentId.get()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

