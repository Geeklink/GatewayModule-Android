# PeripheralInfo.java

Peripheral Info

分机信息

| Field <br/> 字段 | Type <br/> 类型 | Note <br/> 说明 | 
| - | - | - |
| PeripheralId | byte | Peripheral Id <br/> 分机ID |
| PeripheralType | [PeripheralType](PeripheralType.md) | Peripheral Type <br/> 分机类型 |
| Online | boolean | Online Status, Note: some peripheral without heartbeat connect, such as Security RC and Scene Switch, will always be online <br/> 在线状态, 注意: 部分没有心跳的分机, 例如安防遥控器和情景面板, 是一直会在线的 |
| CurtainState | int | Curtain State: 0～100 to 0%～100% <br/> 窗帘状态: 0～100 对应 0%～100% |
| DoorLockV1Battery | int | Door Lock V1 Battery: 0 battery normal / 1 battery low <br/> 门锁1代电量: 0 电池正常 / 1 电量低 |
| DoorLockV1State | int | Door Lock V1 State: 0 unlocked / 1 locked / 2 prying <br/> 门锁1代状态: 0 门没锁好 / 1 门已经锁好 / 2 被撬 |
| DoorLockV2Battery | int | Door Lock V2 Battery: 0~100 to 0%~100%  <br/> 门锁2代电量: 0～100 对应 0%~100% |
| DoorLockV2State | int | Door Lock V2 State: 0 unlocked / 1 locked <br/> 门锁2代状态: 0未锁好 / 1锁好 |
| ManipulatorState | boolean | Manipulator State: true Open / false Closed <br/> 机械手分机状态: true 打开 / false 关闭 |
| RelayBattery | int | Relay Battery: 0~10 to 0%~100%, unit is 10% <br/> 电池中继分机电量: 0～10 对应 0%～100%, 单位是10% |
| RelayHumidity | int | Relay, THI Sensor Humidity: unit is % <br/> 中继分机, 温湿度光照度分机检测湿度: 单位是% |
| RelayTemperature | float | Relay, THI Sensor Temperature: unit: ℃ <br/> 中继分机, 温湿度光照度分机检测温度: 单位是摄氏度(℃) |
| SensorBattery | int | Door, Motion, Water Leak, Smoke, Shake Sensor Battery: 0~5 to 0%~100 <br/> 门磁, 红外, 漏水, 烟雾, 震动等电量, 0～5 对应 0%～100%, 单位是20% |
| SensorState | boolean | Door, Motion, Water Leak, Smoke, Shake Sensor State <br/> Door State: true Detected Open <br/> Motion State: true Detected Somebody <br/> Water Leak State: true Detected Water Leak <br/> Smoke State: true Detected Smoke <br/> Shake State: true Detected Shake <br/> 门磁, 红外, 漏水, 烟雾, 震动等状态 <br/> 门磁检测: false 关 / true 开 <br/> 红外检测: false 无人 / true 有人 <br/> 漏水检测: false 无漏水 / true 有漏水 <br/> 烟雾检测: false 无烟雾 / true 有烟雾 <br/> 震动检测: false 无震动 / true 有震动 |
| SwitchA | boolean | Feedback Switch, IO Module, Connect Module State, Switch A: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第一路: false 关闭 / true 打开 |
| SwitchB | boolean | Feedback Switch, IO Module, Connect Module State, Switch B: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第二路: false 关闭 / true 打开 |
| SwitchC | boolean | Feedback Switch, IO Module, Connect Module State, Switch C: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第三路: false 关闭 / true 打开 |
| SwitchD | boolean | Feedback Switch, IO Module, Connect Module State, Switch D: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第四路: false 关闭 / true 打开 |
| SwitchE | boolean | Feedback Switch, IO Module, Connect Module State, Switch E: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第五路: false 关闭 / true 打开 |
| SwitchF | boolean | Feedback Switch, IO Module, Connect Module State, Switch F: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第六路: false 关闭 / true 打开 |
| SwitchG | boolean | Feedback Switch, IO Module, Connect Module State, Switch G: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第七路: false 关闭 / true 打开 |
| SwitchH | boolean | Feedback Switch, IO Module, Connect Module State, Switch H: false OFF / true ON <br/> 反馈开关, IO模块, 干接点分路状态, 第八路: false 关闭 / true 打开 |
| ThermostatState | [ThermostatState](ThermostatState.md) | Thermostat State <br/> 温控面板状态 |
| THIIllumination | int | THI Sensor Illumination: unit is LUX <br/> 光照度温湿度分机检测光照度, 单位是 LUX |
