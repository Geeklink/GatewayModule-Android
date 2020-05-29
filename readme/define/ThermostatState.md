# ThermostatState.java

Thermostat Status

温控面板状态

| Field <br/> 字段 | Type <br/> 类型 | Note <br/> 说明 | 
| - | - | - |
| Power | boolean | Power: true ON / false OFF <br/> 电源: true 开 / false 关 |
| Mode | byte | Power: 0 Cold / 1 Hot <br/> 模式: 0 制冷 / 1 制热 |
| Speed | byte | Speed: 1 LOW / 2 MED / 3 HI <br/> 风速: 1 低 / 2 中 / 3 高 |
| Temperature | byte | Setting Temperature: 16~30, unit: ℃ <br/> 设定温度: 16～30, 单位: ℃ |
| RoomTemperature | byte | Detection Temperature: unit: ℃ <br/> 当前室内温度: 单位: ℃ |
