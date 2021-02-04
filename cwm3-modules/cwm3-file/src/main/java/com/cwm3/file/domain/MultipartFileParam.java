package com.cwm3.file.domain;

import com.cwm3.common.core.web.domain.BaseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 文件传输对象
 */
public class MultipartFileParam extends BaseEntity implements Serializable {
    private String taskId;
    private int chunk;
    private int size;
    private int chunkTotal;
    private int totalSize;
    private MultipartFile file;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getChunk() {
        return chunk;
    }

    public void setChunk(int chunk) {
        this.chunk = chunk;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getChunkTotal() {
        return chunkTotal;
    }

    public void setChunkTotal(int chunkTotal) {
        this.chunkTotal = chunkTotal;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
