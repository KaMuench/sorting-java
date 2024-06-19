```mermaid 
classDiagram
    class `Sort` { 
        <<interface>>
        +sort(T[] list) T[]$
    }
    
    class `BubbleSort` {
        +sort(T[] list) T[]$
    }
    
    `BubbleSort`..|>`Sort`
```