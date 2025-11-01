// LightResponseDTO.java
package com.example.springbootLab.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LightResponseDTO {
    private String result;
    private String processedBy;

    // getters & setters
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public String getProcessedBy() { return processedBy; }
    public void setProcessedBy(String processedBy) { this.processedBy = processedBy; }
}